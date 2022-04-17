package cn.jho.mall.product.vo.spu;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @author JHO
 */
@Data
public class MemberPrice {

    private Long id;

    private String name;

    private BigDecimal price;

}