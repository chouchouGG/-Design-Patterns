package cn.learn.Strategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description: 直减策略
 * @author: chouchouGG
 * @create: 2024-06-02 08:30
 **/
public class ZJCouponDiscount implements ICouponDiscount {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal price) {
        BigDecimal coupon = new BigDecimal(couponInfo.get("coupon"));
        BigDecimal discountAmount = price.subtract(coupon);
        return BigDecimal.ZERO.max(discountAmount)  ;
    }

}