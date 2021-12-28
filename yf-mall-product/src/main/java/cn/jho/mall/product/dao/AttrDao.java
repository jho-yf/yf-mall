package cn.jho.mall.product.dao;

import cn.jho.mall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:07
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
