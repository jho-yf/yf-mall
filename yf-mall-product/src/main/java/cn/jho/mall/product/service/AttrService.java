package cn.jho.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:07
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

