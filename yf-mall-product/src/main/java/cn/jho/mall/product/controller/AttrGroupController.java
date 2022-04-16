package cn.jho.mall.product.controller;

import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.R;
import cn.jho.mall.product.entity.AttrEntity;
import cn.jho.mall.product.entity.AttrGroupEntity;
import cn.jho.mall.product.service.AttrAttrgroupRelationService;
import cn.jho.mall.product.service.AttrGroupService;
import cn.jho.mall.product.service.AttrService;
import cn.jho.mall.product.service.CategoryService;
import cn.jho.mall.product.vo.AttrGroupRelationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 属性分组
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-28 20:31:25
 */
@RestController
@RequestMapping("product/attrgroup")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AttrGroupController {

    private final AttrGroupService attrGroupService;

    private final CategoryService categoryService;

    private final AttrService attrService;

    private final AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/list/{categoryId}")
    public R listByCategoryId(@PathVariable Long categoryId, @RequestParam Map<String, Object> params) {
        PageUtils page = attrGroupService.queryPage(params, categoryId);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    // @RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        // 查询完整路径
        attrGroup.setCatelogPath(categoryService.findCategoryPath(attrGroup.getCatelogId()));
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));
        return R.ok();
    }

    @GetMapping("/{attrGroupId}/attr/relation")
    public R getAttrGroupAttrRelation(@PathVariable("attrGroupId") Long attrGroupId) {
        List<AttrEntity> entities = attrService.getRelationAttr(attrGroupId);
        return R.ok().put("data", entities);
    }

    @GetMapping("/{attrGroupId}/noattr/relation")
    public R getAttrGroupAttrNoRelation(@PathVariable("attrGroupId") Long attrGroupId,
                                        @RequestParam Map<String, Object> params) {
        PageUtils page = attrService.getNoRelationAttr(attrGroupId, params);
        return R.ok().put("page", page);
    }

    @PostMapping("/attr/relation/delete")
    public R deleteAttrGroupAttrRelation(@RequestBody List<AttrGroupRelationVO> relationVOs) {
        attrService.deleteRelation(relationVOs);
        return R.ok();
    }

    @PostMapping("/attr/relation")
    public R relateAttr(@RequestBody List<AttrGroupRelationVO> attrGroupRelationVOS) {
        attrAttrgroupRelationService.saveBatch(attrGroupRelationVOS);
        return R.ok();
    }

}
