package mlm.noretrofit.library.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import mlm.noretrofit.library.util.Utils;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-29  00:10
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class NoRetrofitHandler implements InvocationHandler {

    private String baseUrl;

    NoRetrofitHandler(String baseUrl){
        this.baseUrl=baseUrl;
    }


    /**
     * proxy表示下面2.3 通过 Proxy.newProxyInstance() 生成的代理类对象。
     * method表示代理对象被调用的函数。
     * args表示代理对象被调用的函数的参数。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RunTimeParser runTimeParser = Utils.getFromMethodCache(method);

        try{
            if(runTimeParser!=null){
                //将
                return runTimeParser.invoke(baseUrl,args);
            }else{
                return method.invoke(this,args);
            }
        }catch (InvocationTargetException e){
            throw e.getCause();

        }



    }
}
