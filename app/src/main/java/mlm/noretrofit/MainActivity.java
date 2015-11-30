package mlm.noretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

import mlm.noretrofit.library.core.NoRetrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SnakeService snakeService = NoRetrofit.create("http://api.openweathermap.org/data/2.5", SnakeService.class);

        HashMap<String, String> map = new HashMap<>();
        map.put("bean","1");
        //snakeService.getBean(map);
    }


}
