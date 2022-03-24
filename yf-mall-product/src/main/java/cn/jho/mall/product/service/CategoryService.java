package cn.jho.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:07
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * 根据条件分页查询
     *
     * @param params 查询条件
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 以树的形式查询分类列表
     *
     * @return {@link CategoryEntity}
     */
    List<CategoryEntity> listWithTree();
}

