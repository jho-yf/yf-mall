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

    /**
     * 根据分类id查询分类所在路径 [所在分类， 子， 孙, ...]
     *
     * @param catelogId 分类id
     * @return 分类路径
     */
    List<Long> findCategoryPath(Long catelogId);

    /**
     * 更新分类（保证冗余字段数据一致）
     *
     * @param category {@link CategoryEntity} 分类实体
     */
    void updateDetailById(CategoryEntity category);
}

