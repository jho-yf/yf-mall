package cn.jho.common.exception;

import cn.jho.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一Controller异常处理
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-27 11:21
 */
@Slf4j
@RestControllerAdvice(basePackages = "cn.jho.mall")
public class YfMallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验失败：{}", e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>(16);
        bindingResult.getFieldErrors().forEach(errorField -> {
            map.put(errorField.getField(), errorField.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMessage()).put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        log.error("未知异常：{}", throwable.getMessage());
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());
    }

}
