package cn.jho.mall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 品牌视图对象
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-16 18:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandRespVO {

    private Long brandId;

    private String brandName;

}
