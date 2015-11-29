package mlm.noretrofit.library.core;

import com.squareup.okhttp.OkHttpClient;

import java.lang.reflect.Method;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  22:43
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class RunTimeParser {

    private Method method;
    private OkHttpClient okHttpClient;


    public RunTimeParser(Method method, OkHttpClient okHttpClient) {
        this.method=method;
        this.okHttpClient=okHttpClient;
        //解析操作
        parserRunTimeAnno();

    }

    private void parserRunTimeAnno() {
        //TODO


    }

    public Object invoke(String baseUrl, Object[] args) {


        return null;
    }
}
