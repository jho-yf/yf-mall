package cn.jho.common.exception;

/**
 * 错误码和错误信息定义类
 *  1. 错误码定义规则为5为数字
 *  2. 前两位表示业务场景，最后三位表示错误码。例如：100001。10:通用 001:系统未知异常
 *  3. 维护错误码后需要维护错误描述，将他们定义为枚举形式
 * 错误码列表：
 *  10: 通用
 *      001：参数格式校验
 *  11: 商品
 *  12: 订单
 *  13: 购物车
 *  14: 物流
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-27 11:09
 */
public enum BizCodeEnum {

    /** 系统未知异常 */
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    /** 参数格式校验失败 */
    VALID_EXCEPTION(10001, "参数格式校验失败");

    private final int code;

    private final String message;

    BizCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
