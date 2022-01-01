package cn.jho.mall.coupon.dao;

import cn.jho.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-01-01 11:03:06
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
