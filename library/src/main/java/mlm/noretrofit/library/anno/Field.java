package mlm.noretrofit.library.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  18:38
 * Base on Meilimei.com (PHP Service)
 * Describe:
 *
 *      @FormUrlEncoded
 *      @POST("/user/edit")
 *      Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);
 *
 * Version:1.0
 * Open source
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface Field {
    String value();
}
