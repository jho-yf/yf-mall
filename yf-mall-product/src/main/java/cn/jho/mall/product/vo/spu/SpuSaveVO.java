package cn.jho.mall.product.vo.spu;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * Spu保存视图对象
 *
 * @author JHO
 */
@Data
public class SpuSaveVO {

    private String spuName;

    private String spuDescription;

    private Long catalogId;

    private Long brandId;

    private BigDecimal weight;

    private Integer publishStatus;

    private List<String> decript;

    private List<String> images;

    private Bounds bounds;

    private List<BaseAttrs> baseAttrs;

    private List<Skus> skus;

}