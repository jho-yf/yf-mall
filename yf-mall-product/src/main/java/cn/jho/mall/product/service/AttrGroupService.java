package cn.jho.mall.product.service;

import cn.jho.mall.product.vo.AttrGroupWithAttrsVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.AttrGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:06
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    /**
     * 分页查询属性分组
     *
     * @param params 查询参数
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据categoryId分页查询属性分组
     *
     * @param params 查询参数
     * @param categoryId 分类id
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params, Long categoryId);

    /**
     * 获取某个分类下所有的属性分组以及分组下的属性
     *
     * @param catelogId 分类id
     * @return {@link List<AttrGroupWithAttrsVO>}
     */
    List<AttrGroupWithAttrsVO> getAttrGroupWithAttrsByCatelogId(Long catelogId);
}

