package cn.jho.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:06
 */
public interface BrandService extends IService<BrandEntity> {

    /**
     * 按条件分页查询
     *
     * @param params 查询条件
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 更新品牌（保证冗余字段数据一致）
     *
     * @param brand {@link BrandEntity} 品牌实体
     */
    void updateDetailById(BrandEntity brand);
}

