package cn.jho.common.data.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * spu积分传输对象
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-19 7:30
 */
@Data
public class SpuBoundTo {

    /** spu id */
    private Long spuId;

    /** 成长积分 */
    private BigDecimal buyBounds;

    /** 购物积分 */
    private BigDecimal growBounds;

}
