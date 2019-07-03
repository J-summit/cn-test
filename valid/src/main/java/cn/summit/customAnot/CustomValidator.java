package cn.summit.customAnot;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author onlyo
 * @since 2019/7/2 22:41
 */
public class CustomValidator implements ConstraintValidator<Custom, String> {

    private String str;

    private String startWith;

    @Override
    public void initialize(Custom constraintAnnotation) {
        this.str = constraintAnnotation.str();
        this.startWith = constraintAnnotation.startWith();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (value.startsWith(startWith)) {
            return true;
        }
        if (str.equals(value)) {
            return true;
        }

        return false;
    }
}
