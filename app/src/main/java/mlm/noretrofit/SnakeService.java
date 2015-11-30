package mlm.noretrofit;

import java.util.Map;

import mlm.noretrofit.library.anno.GET;
import mlm.noretrofit.library.anno.QueryMap;
import mlm.noretrofit.library.anno.RetrofitAPI;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  20:07
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
@RetrofitAPI
public interface SnakeService {


    @GET("/weather")
    Bean getBean(@QueryMap Map<String, String> coordinates);

}
