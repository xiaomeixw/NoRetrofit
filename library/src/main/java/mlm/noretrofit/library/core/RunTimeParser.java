package mlm.noretrofit.library.core;

import android.net.Uri;

import com.squareup.okhttp.OkHttpClient;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mlm.noretrofit.library.anno.Field;
import mlm.noretrofit.library.anno.GET;
import mlm.noretrofit.library.anno.Header;
import mlm.noretrofit.library.anno.POST;
import mlm.noretrofit.library.anno.Path;
import mlm.noretrofit.library.anno.Query;
import mlm.noretrofit.library.anno.QueryMap;
import mlm.noretrofit.library.http.HttpType;
import mlm.noretrofit.library.http.Request;
import mlm.noretrofit.library.http.parser.JsonParser;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  22:43
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class RunTimeParser {

    private Method mMethod;
    private OkHttpClient okHttpClient;
    private HttpType mHttpType;
    private String mHttpPath;
    private Type returnType;
    private JsonParser JsonParser;

    private Map<Integer, String> queryParams = new HashMap<>();
    private Map<Integer, String> bodyParams = new HashMap<>();
    private Map<Integer, String> pathParams = new HashMap<>();
    private Map<Integer, String> headerParams = new HashMap<>();


    private int indexOfQueryParamObject;
    private boolean haveQueryParamObject;


    public RunTimeParser(Method method, OkHttpClient okHttpClient) {
        this.mMethod = method;
        this.okHttpClient = okHttpClient;
        //解析操作
        parserRunTimeAnno();

    }

    private void parserRunTimeAnno() {
        if (mMethod.isAnnotationPresent(GET.class)) {
            //如果使用@GET修饰-->指定为get请求,同时拿到注解的值
            mHttpType = HttpType.GET;
            mHttpPath = mMethod.getAnnotation(GET.class).value();
        } else if (mMethod.isAnnotationPresent(POST.class)) {
            mHttpType = HttpType.POST;
            mHttpPath = mMethod.getAnnotation(POST.class).value();
        } else {
            throw new IllegalArgumentException("For instance only support for @GET & @POST");
        }

        ///得到目标方法返回类型对应的Type对象
        returnType = mMethod.getGenericReturnType();

        //如果方法的返回值为void,抱异常
        if (returnType == Void.class) {
            throw new IllegalArgumentException("when you use noRetrofit @GET/@POST method should have return value");
        }

        //指定json解析器
        JsonParser = new JsonParser(returnType);

        //对方法中的参数进行处理
        //Method.getParameterAnnotations()方法返回一个注解类型的二维数组，每一个方法的参数包含一个注解数组
        Annotation[][] parameterAnnotations = mMethod.getParameterAnnotations();

        handlerParams(parameterAnnotations);

    }

    /**
     * 将一个方法中的参数注解放入一个Map集合
     *
     * @param parameterAnnotationsArrays
     */
    private void handlerParams(Annotation[][] parameterAnnotationsArrays) {

        //parameterAnnotationsArrays得到的是Service.class里面所有方法的参数注解

        for (int i = 0; i < parameterAnnotationsArrays.length; i++) {
            //拿到一个方法的参数注解
            Annotation[] parameterAnnotationsArray = parameterAnnotationsArrays[i];
            if (parameterAnnotationsArray != null) {
                //一个方法的参数里面可能有1个注解参数，也可能有多个注解参数
                for (Annotation parameterAnnotation : parameterAnnotationsArray) {
                    Class<? extends Annotation> annotationType = parameterAnnotation.annotationType();
                    //如果方法的参数的注解标示识@Query:GET - single params
                    if (annotationType == Query.class) {
                        queryParams.put(i, ((Query) parameterAnnotation).value());
                        //@Query:GET - map
                    } else if (annotationType == QueryMap.class) {
                        indexOfQueryParamObject = i;
                        haveQueryParamObject = true;
                        //@Path - {} url
                    } else if (annotationType == Path.class) {
                        pathParams.put(i, ((Path) parameterAnnotation).value());
                        //@Header
                    } else if (annotationType == Header.class) {
                        headerParams.put(i, ((Header) parameterAnnotation).value());
                        //@POST - single params
                    } else if (annotationType == Field.class) {
                        bodyParams.put(i, ((Field) parameterAnnotation).value());
                    }
                }

            }

        }


    }


    /**
     * args表示代理对象被调用的函数的参数
     *
     * @param baseUrl
     * @param args
     * @return
     */
    public Object invoke(String baseUrl, Object[] args) throws IllegalAccessException {

        //开启一个请求处理
        Request request = new Request();

        //拼接全URL路径
        String fullUrl = baseUrl + mHttpPath;

        //给request开始设置数据包裹
        setRequestValue(request, fullUrl, args);


        return null;
    }

    private void setRequestValue(Request request, String fullUrl, Object[] args) throws IllegalAccessException {
        ArrayList<NameValuePair> paramsList = new ArrayList<>();
        //通过解析注解,得到是get还是post请求
        request.setHttpType(mHttpType);
        request.setFullUrl(fullUrl);

        //针对情形一:http://www.noretrofit.org/user/{id}
        if (pathParams.size() > 0) {
            fullUrl = parserPathParams(fullUrl, pathParams, args);
        }

        //针对情形二:List<User> groupList(@QueryMap Map<String, String> options);
        if (haveQueryParamObject) {
            paramsList.addAll(parserQueryMap(args[indexOfQueryParamObject]));

        }

    }


    /**
     * http://www.noretrofit.org/user/{id}
     * 将用户设置的id值替换url地址上的
     *
     * @param path
     * @param params
     * @param args
     * @return
     */
    private String parserPathParams(String path, Map<Integer, String> params, Object[] args) {
        for (Map.Entry<Integer, String> pathValue : pathParams.entrySet()) {
            Object paramVal = args[pathValue.getKey()];
            if (paramVal == null) {
                throw new IllegalArgumentException(String.format("\"Can not be null params\", placeholder.getValue())"));
            }
            String value = Uri.encode(paramVal.toString());
            //value 替换 {} 中的pathValue
            path = path.replaceAll("\\{(" + pathValue.getValue() + ")\\}", value);

        }
        return path;
    }

    /**
     * List<User> groupList(@QueryMap Map<String, String> options);
     * List<User> groupList(@QueryMap Object options);
     * 封装get请求参数
     *
     * @param object
     * @return
     */
    private Collection<? extends NameValuePair> parserQueryMap(Object object) throws IllegalAccessException {

        Map<String, Object> fieldParams;

        //分为两种情况:map 或者 object

        try {
            //如果传入的参数是Map<String, String> options
            fieldParams = (Map<String, Object>) object;
        } catch (ClassCastException e) {
            //如果传入的参数是Object
            Class<?> paramClass = object.getClass();
            java.lang.reflect.Field[] fields = paramClass.getDeclaredFields();
            fieldParams = new HashMap<String, Object>();

            for (int i = 0; i < fields.length; i++) {
                java.lang.reflect.Field field = fields[i];
                field.setAccessible(true);
                fieldParams.put(field.getName(),field.get(object));
            }
        }

        ArrayList<NameValuePair> vals = new ArrayList<>();

        for (Map.Entry<String,Object> queryParamEntry  : fieldParams.entrySet()){
            if(queryParamEntry.getValue()!=null){
                String value = Uri.encode(queryParamEntry.getValue().toString());
                vals.add(new BasicNameValuePair(queryParamEntry.getKey(),value));
            }
        }

        return vals;
    }
}
