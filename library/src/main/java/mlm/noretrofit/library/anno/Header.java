package mlm.noretrofit.library.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  17:55
 * Base on Meilimei.com (PHP Service)
 * Describe:
 *
 *      @GET("/user")
 *      Call<User> getUser(@Header("Authorization") String authorization)
 *
 * Version:1.0
 * Open source
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Header {
    String value();
}
