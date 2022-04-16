package cn.jho.mall.product.service;

import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.BrandEntity;
import cn.jho.mall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-04-12 06:47:12
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    /**
     * 按条件分页查询
     *
     * @param params 查询参数
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存分类和品牌关系
     *
     * @param categoryBrandRelation {@link CategoryBrandRelationEntity}
     * @return 是否保存成功
     */
    boolean saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    /**
     * 根据id更新所有品牌名称
     *
     * @param brandId 品牌id
     * @param name 品牌名称
     */
    void updateBrand(Long brandId, String name);

    /**
     * 根据id更新所有分类名称
     *
     * @param catId 分类id
     * @param name 分类名称
     */
    void updateCategory(Long catId, String name);

    /**
     * 获取分类下所有的品牌
     *
     * @param catId 分类id
     * @return 品牌实体 {@link BrandEntity}
     */
    List<BrandEntity> getBrandsByCatId(Long catId);
}

