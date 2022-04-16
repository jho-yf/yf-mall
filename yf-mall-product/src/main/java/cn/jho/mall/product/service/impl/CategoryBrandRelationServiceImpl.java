package cn.jho.mall.product.service.impl;

import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.Query;
import cn.jho.mall.product.dao.CategoryBrandRelationDao;
import cn.jho.mall.product.entity.BrandEntity;
import cn.jho.mall.product.entity.CategoryBrandRelationEntity;
import cn.jho.mall.product.entity.CategoryEntity;
import cn.jho.mall.product.service.BrandService;
import cn.jho.mall.product.service.CategoryBrandRelationService;
import cn.jho.mall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author JHO
 */
@Service("categoryBrandRelationService")
@Slf4j
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public boolean saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();
        try {
            BrandEntity brandEntity = brandService.getById(brandId);
            CategoryEntity categoryEntity = categoryService.getById(catelogId);
            categoryBrandRelation.setBrandName(brandEntity.getName());
            categoryBrandRelation.setCatelogName(categoryEntity.getName());
        } catch (Exception e) {
            log.error("保存品牌分类关系失败：品牌id【{}】，分类id【{}】", brandId, catelogId);
            e.printStackTrace();
            return false;
        }
        return this.save(categoryBrandRelation);
    }

    @Override
    public void updateBrand(Long brandId, String name) {
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setBrandId(brandId);
        relationEntity.setBrandName(name);
        this.update(relationEntity, new UpdateWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
    }

    @Override
    public void updateCategory(Long catId, String name) {
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setCatelogId(catId);
        relationEntity.setCatelogName(name);
        this.update(relationEntity, new UpdateWrapper<CategoryBrandRelationEntity>().eq("catelog_id", catId));
    }

    @Override
    public List<BrandEntity> getBrandsByCatId(Long catId) {
        List<CategoryBrandRelationEntity> relationEntities = this.list(
                new QueryWrapper<CategoryBrandRelationEntity>().eq("catelog_id", catId));
        return relationEntities.stream()
                .map(entity -> brandService.getById(entity.getBrandId()))
                .collect(Collectors.toList());
    }

}