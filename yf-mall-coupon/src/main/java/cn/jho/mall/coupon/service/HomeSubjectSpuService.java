package cn.jho.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-01-01 11:03:06
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

