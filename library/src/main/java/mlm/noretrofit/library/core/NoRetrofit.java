package mlm.noretrofit.library.core;


import com.squareup.okhttp.OkHttpClient;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import mlm.noretrofit.library.anno.GET;
import mlm.noretrofit.library.anno.POST;
import mlm.noretrofit.library.log.RetrofitLog;
import mlm.noretrofit.library.util.Utils;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  22:59
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class NoRetrofit {


    /**
     * 利用动态代理获取Service类对象
     *
     * @param apiEndpointUrl BaseUrl地址
     * @param serviceClass   ServiceAPI
     */
    public static <T> T create(String apiEndpointUrl, Class<T> serviceClass) {

        RetrofitLog.i("------Retrofit------");

        T service;

        //Service类必须是接口
        Utils.checkServiceInter(serviceClass);

        //Service类上必须有注解@RetrofitAPI标记
        boolean mWithRetrofitMark = Utils.checkHaveRetrofitAPI(serviceClass);

        if (mWithRetrofitMark) {

            //先从缓存中取,key是service的name
            service = Utils.getFromCache(serviceClass.getName());

            if (service != null) {

                //动态代理去拿service类对象
                service = (T) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class[]{serviceClass},
                        new NoRetrofitHandler(apiEndpointUrl)
                );

                //存入Service-Map集合中
                T found = Utils.putInCache(serviceClass.getName(), service);

                //担心返回的是null,防止Null指针异常
                if (found != null) {
                    service = found;
                }

                //然后分解service中的方法,存入另一个专门map集合中
                setMethodDataCache(serviceClass, new OkHttpClient());


            }

        } else {
            throw new IllegalArgumentException("need use @RetrofitAPI Mark service");

        }

        return service;


    }

    private static void setMethodDataCache(Class serviceClass, OkHttpClient okHttpClient) {
        for(Method method : serviceClass.getMethods()){
            //有@GET和@POST
            if(method.isAnnotationPresent(GET.class)||method.isAnnotationPresent(POST.class)){
                Utils.putInMethodCache(method,new RunTimeParser(method,okHttpClient));
            }
        }
    }


}
