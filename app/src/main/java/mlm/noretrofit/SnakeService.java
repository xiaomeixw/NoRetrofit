package mlm.noretrofit;

import java.util.Map;

import mlm.noretrofit.library.anno.Field;
import mlm.noretrofit.library.anno.GET;
import mlm.noretrofit.library.anno.Header;
import mlm.noretrofit.library.anno.POST;
import mlm.noretrofit.library.anno.Path;
import mlm.noretrofit.library.anno.Query;
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


    @GET("/tehui/getNewTehuiDetailById")
    JsonBean<Bean> getBean(@QueryMap Map<String, String> coordinates);

    @GET("/user/{id}")
    String getUser(@Path("id") String id);

    @POST("/user/signin")
    UserInfo getLogin(@Field("username") String username, @Field("password") String password);


    @GET("/tehui/getNewTehuiDetailById")
    JsonBean<Bean> getHeader(@QueryMap Map<String, String> coordinates,@Header("Content-Type") String head);


    @GET("/tehui/getNewTehuiDetailById")
    JsonBean<Bean> getQuery(@Query("t_id") String t_id,@Query("signapp") String sign_app);
}
