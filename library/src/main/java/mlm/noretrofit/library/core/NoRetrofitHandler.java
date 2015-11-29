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


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RunTimeParser runTimeParser = Utils.getFromMethodCache(method);

        try{
            if(runTimeParser!=null){
                return runTimeParser.invoke(baseUrl,args);
            }else{
                return method.invoke(this,args);
            }
        }catch (InvocationTargetException e){
            throw e.getCause();

        }



    }
}
