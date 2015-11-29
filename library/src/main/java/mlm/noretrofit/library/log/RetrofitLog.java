package mlm.noretrofit.library.log;

import android.util.Log;

import mlm.noretrofit.library.constans.Constant;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  21:50
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class RetrofitLog {

    private static final String TAG="RETROFITLOG";

    public static void i(String log){
        if(Constant.DEBUG_SWITCH){
            Log.i("TAG",log);
        }
    }
}
