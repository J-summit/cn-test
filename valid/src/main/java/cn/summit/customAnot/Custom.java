package cn.summit.customAnot;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author onlyo
 * @since 2019/7/2 22:41
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {cn.summit.customAnot.CustomValidator.class})
public @interface Custom {

    String message() default "自定义检验error";

    String str() default "str";

    String startWith() default "xxx";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Custom[] value();
    }
}
