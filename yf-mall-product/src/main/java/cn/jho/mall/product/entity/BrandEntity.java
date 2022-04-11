package cn.jho.mall.product.entity;

import cn.jho.common.valid.ListValue;
import cn.jho.common.valid.group.AddGroup;
import cn.jho.common.valid.group.UpdateGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:06
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(groups = AddGroup.class, message = "新增不能指定brandId")
	@NotNull(groups = UpdateGroup.class, message = "修改必须指定brandId")
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(groups = AddGroup.class, message = "品牌名必填")
	@Length(groups = UpdateGroup.class, min = 1, message = "品牌名不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty(groups = AddGroup.class)
	@URL(groups = {AddGroup.class, UpdateGroup.class}, message = "logo必须是一个合法的url地址")
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ListValue(value = {0, 1}, groups = AddGroup.class)
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@Pattern(groups = {AddGroup.class, UpdateGroup.class}, regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母")
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups = AddGroup.class)
	@Min(groups = {AddGroup.class, UpdateGroup.class}, value = 0, message = "排序必须大于或等于0")
	private Integer sort;

}
