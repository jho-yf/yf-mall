package cn.jho.mall.product.vo;

import lombok.Data;

/**
 * 属性和属性分组关联的视图对象
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-14 7:25
 */
@Data
public class AttrGroupRelationVO {

    /** 属性id */
    private Long attrId;

    /** 属性分组id */
    private Long attrGroupId;

}
