package cn.jho.mall.product.controller;

import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.R;
import cn.jho.mall.product.entity.BrandEntity;
import cn.jho.mall.product.entity.CategoryBrandRelationEntity;
import cn.jho.mall.product.service.CategoryBrandRelationService;
import cn.jho.mall.product.vo.BrandRespVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 品牌分类关联
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-04-12 06:47:12
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
        boolean isSave = categoryBrandRelationService.saveDetail(categoryBrandRelation);
        if (!isSave) {
            return R.error("保存失败");
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 获取品牌关联的所有分类列表
     */
    @GetMapping("/catelog/list")
    // @RequiresPermissions("product:categorybrandrelation:list")
    public R listCatelogs(@RequestParam("brandId") Long brandId){
        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(
                new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId)
        );
        return R.ok().put("data", data);
    }

    @GetMapping("/brands/list")
    public R listBrands(@RequestParam("catId") Long catId) {
        List<BrandEntity> data = categoryBrandRelationService.getBrandsByCatId(catId);
        List<BrandRespVO> vos = data.stream()
                .map(entity -> new BrandRespVO(entity.getBrandId(), entity.getName()))
                .collect(Collectors.toList());
        return R.ok().put("data", vos);
    }

}
