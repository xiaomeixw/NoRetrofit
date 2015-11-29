package mlm.noretrofit.library.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  23:27
 * Describe: 这个是额外添加的注解
 * Ta存在的作用就是:开发者在servie上做标注,主观性的告知开发者这个类是APIService类
 * 我会在解析Service类时用方法：
 *
 *  service.isAnnotationPresent(RetrofitAPI.class)方法:
 *      如果指定类型的@RetrofitAPI注释存在于此接口元素上, 方法返回true,否则返回false。
 *      这种方法的设计主要是为了方便访问标记注释
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RetrofitAPI {
}
