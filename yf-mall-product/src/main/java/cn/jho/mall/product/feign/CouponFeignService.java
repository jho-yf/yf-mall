package cn.jho.mall.product.feign;

import cn.jho.common.data.to.SpuBoundTo;
import cn.jho.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 优惠业务Feign服务
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-19 7:26
 */
@FeignClient("yf-mall-coupon")
public interface CouponFeignService {

    /**
     * 保存spu积分信息
     *
     * @param spuBoundTo spu积分传输对象 {@link SpuBoundTo}
     * @return 统一返回对象 {@link R}
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

}
