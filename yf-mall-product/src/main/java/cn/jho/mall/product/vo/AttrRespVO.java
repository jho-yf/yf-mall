package cn.jho.mall.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-13 20:22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVO extends AttrVO {

    /** 分类名称 */
    private String catelogName;

    /** 分组名称 */
    private String groupName;

    /** 分类路径 */
    private List<Long> catelogPath;

}
