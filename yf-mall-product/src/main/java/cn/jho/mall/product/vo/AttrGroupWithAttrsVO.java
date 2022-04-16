package cn.jho.mall.product.vo;

import cn.jho.mall.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-16 19:07
 */
@Data
public class AttrGroupWithAttrsVO {

    /** 分组id */
    private Long attrGroupId;

    /** 组名 */
    private String attrGroupName;

    /** 排序 */
    private Integer sort;

    /** 描述 */
    private String descript;

    /** 组图标 */
    private String icon;

    /** 所属分类id */
    private Long catelogId;

    /** 属性 */
    private List<AttrEntity> attrs;

}
