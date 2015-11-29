package mlm.noretrofit.library.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  20:14
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface QueryParams {
    String value() default "";
}
