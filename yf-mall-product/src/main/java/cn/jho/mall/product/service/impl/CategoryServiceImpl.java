package cn.jho.mall.product.service.impl;

import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.Query;
import cn.jho.mall.product.dao.CategoryDao;
import cn.jho.mall.product.entity.CategoryEntity;
import cn.jho.mall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author JHO
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 查出所有分类
        List<CategoryEntity> entities = this.baseMapper.selectList(null);

        // 组装成树形结构
        // 查找所有一级分类，parentCid为0说明是一级分类
        return entities.stream()
                .filter(entity -> entity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> findCategoryPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        findCategoryPath(catelogId, paths);
        return paths;
    }

    private void findCategoryPath(Long catelogId, List<Long> paths) {
        paths.add(0, catelogId);
        CategoryEntity category = this.getById(catelogId);
        Long parentCid = category.getParentCid();
        if (parentCid != null && parentCid != 0) {
            findCategoryPath(parentCid, paths);
        }
    }

    /**
     * 递归查找某个菜单的子菜单
     *
     * @param root 根菜单
     * @param all 所有菜单列表
     * @return {@link List<CategoryEntity>}
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(entity -> entity.getParentCid().equals(root.getCatId()))
                .map(entity -> {
                    entity.setChildren(getChildren(entity, all));
                    return entity;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }

}