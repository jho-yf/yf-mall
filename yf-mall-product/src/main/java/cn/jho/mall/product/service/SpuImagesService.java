package cn.jho.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.SpuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:06
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    /**
     * 根据参数分页查询spu图片
     *
     * @param params 参数
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 将图片批量保存至某个spu下
     *
     * @param spuId spu id
     * @param images 图片地址数组
     */
    void saveImages(Long spuId, List<String> images);
}

