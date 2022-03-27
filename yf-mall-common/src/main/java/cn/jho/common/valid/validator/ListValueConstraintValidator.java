package cn.jho.common.valid.validator;

import cn.jho.common.valid.ListValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-27 17:33
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    /**
     * 初始化方法
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] values = constraintAnnotation.value();
        for (int val : values) {
            set.add(val);
        }
    }

    /**
     * 判断是否校验成功
     *
     * @param value 被注解的目标变量
     * @param context 校验环境上下文
     * @return 是否校验成功
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }

}
