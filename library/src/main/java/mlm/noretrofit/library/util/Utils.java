package mlm.noretrofit.library.util;

import org.apache.http.NameValuePair;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import mlm.noretrofit.library.anno.RetrofitAPI;
import mlm.noretrofit.library.core.RunTimeParser;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  23:17
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class Utils {

    //缓存Service类：ConcurrentHashMap是Java 5中支持高并发、高吞吐量的线程安全HashMap实现
    //see : http://www.iteye.com/topic/344876
    private static ConcurrentHashMap<String, Object> cacheServices = new ConcurrentHashMap<String, Object>();

    //缓存method方法
    private static ConcurrentHashMap<Method, RunTimeParser> cacheMethodServices = new ConcurrentHashMap<>();

    /**
     * 检查是否是接口
     *
     * @param service
     * @param <T>
     */
    public static <T> void checkServiceInter(Class<T> service) {

        if (!service.isInterface()) {
            //不合法的参数异常
            throw new IllegalArgumentException("APIService must Interface");
        }

    }

    /**
     * 检查service类上是否有注解@RetrofitAPI
     *
     * @param service
     * @param <T>
     * @return
     */
    public static <T> boolean checkHaveRetrofitAPI(Class<T> service) {
        if (service.isAnnotationPresent(RetrofitAPI.class)) {
            return true;
        }
        return false;
    }

    /**
     * 从缓存中拿Service对象
     *
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T getFromCache(String name) {
        T service = (T) cacheServices.get(name);
        return service;
    }

    /**
     * 并发HashMap的put是直接放入并替换，putIfAbsent是有就不替换。
     *
     * @param key
     * @param service
     * @param <T>
     */
    public static <T> T putInCache(String key, T service) {
        return (T) cacheServices.putIfAbsent(key, service);
    }

    /**
     * 存method进cache
     *
     * @param method
     * @param runTimeParser
     */
    public static void putInMethodCache(Method method, RunTimeParser runTimeParser) {
        cacheMethodServices.putIfAbsent(method, runTimeParser);
    }

    /**
     * 从cache中取method
     * @param method
     * @return
     */
    public static RunTimeParser getFromMethodCache(Method method){
        return cacheMethodServices.get(method);
    }

    /**
     * 将@GET的map转成get请求的URL地址的拼接
     * ?t_id=2500&signapp=893F86E4DC4CE0905628AECFBF8F1D2F
     * @param queryParams
     * @return
     */
    public static String linkQueryMapParam(List<NameValuePair> queryParams) {
        String url="";
        if (queryParams != null) {
            url += "?";
            for(int i= 0 ; i < queryParams.size();i++){
                try {
                    url += (queryParams.get(i).getName() + "=" + getEncodeString(queryParams.get(i).getValue()) + "&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    private static String getEncodeString(String content) throws UnsupportedEncodingException {
        return content == null ? null : URLEncoder.encode(content, "UTF-8");
    }
}
