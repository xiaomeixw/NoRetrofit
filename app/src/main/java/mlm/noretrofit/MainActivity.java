package mlm.noretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;

import mlm.noretrofit.library.core.NoRetrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();

        final com.squareup.okhttp.Request trueRequest = new com.squareup.okhttp.Request.Builder()
                .url("http://www.mlm.com/v6/tehui/getNewTehuiDetailById?t_id=2500&signapp=1245212354755112")
                .build();


           okHttpClient.newCall(trueRequest).enqueue(new Callback() {
               @Override
               public void onFailure(Request request, IOException e) {

               }

               @Override
               public void onResponse(Response response) throws IOException {
                   String responseUrl = response.body().string();
                   //RetrofitLog.i("responseUrl="+responseUrl);
               }
           });




        SnakeService snakeService = NoRetrofit.create("http://www.mlm.com/v6", SnakeService.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("t_id","2500");
        map.put("signapp", "1245212354755112");
        JsonBean<Bean> bean = snakeService.getBean(map);

        ((TextView)findViewById(R.id.tvText1)).setText(bean.getData().toString());


        UserInfo login = snakeService.getLogin("18664633705", "123456789");
        ((TextView)findViewById(R.id.tvText2)).setText(login.toString());


        String user = snakeService.getUser("1");
        //((TextView)findViewById(R.id.tvText3)).setText(user.toString());

        JsonBean<Bean> header = snakeService.getHeader(map, "application/json; charset=UTF-8");

        JsonBean<Bean> query = snakeService.getQuery("2500", "1245212354755112");
        ((TextView)findViewById(R.id.tvText3)).setText(query.getData().toString());

    }


}
