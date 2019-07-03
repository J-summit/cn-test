package cn.summit;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class ValidationUtils {

    /**
     * 使用hibernate的注解来进行验证
     */
//    private static Validator validator = Validation
//            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
//
    public static Validator getValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = getValidator().validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
//            throw new Exception("0001", String.format("参数校验失败:%s", constraintViolations.iterator().next().getMessage()));
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                log.error(constraintViolation.getPropertyPath().toString() +":"+ constraintViolation.getMessage()+"当前值为:"+constraintViolation.getInvalidValue());

            }
        }
    }
}