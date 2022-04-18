package cn.jho.mall.product.service;

import cn.jho.mall.product.vo.spu.BaseAttrs;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.ProductAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:07
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    /**
     * 按参数分页查询spu属性值
     *
     * @param params 查询参数
     * @return 分页工具 - {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 将spu属性批量保存至某个spu下
     *
     * @param spuId spu id
     * @param baseAttrs 属性列表
     */
    void saveAttrValues(Long spuId, List<BaseAttrs> baseAttrs);
}

