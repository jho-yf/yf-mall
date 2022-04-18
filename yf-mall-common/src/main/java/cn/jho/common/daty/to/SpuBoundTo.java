package cn.jho.common.daty.to;

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

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
