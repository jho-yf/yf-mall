package cn.jho.mall.ware.dao;

import cn.jho.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-01-01 11:49:21
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
