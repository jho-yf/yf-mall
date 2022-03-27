package cn.jho.common.valid;

import cn.jho.common.valid.validator.ListValueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-27 17:03
 */
@Documented
@Constraint(validatedBy = { ListValueConstraintValidator.class })                                                      // 指定校验器
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })       // 注解可以标注的地方
@Retention(RUNTIME)                                                                 // 在运行时可以获取到
public @interface ListValue {

    // 默认在resources/ValidationMessages.properties中获取此信息
    String message() default "{cn.jho.common.valid.ListValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int[] value() default {};

}
