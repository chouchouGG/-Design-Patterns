package cn.learn.Strategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description: 满减策略
 * @author: chouchouGG
 * @create: 2024-06-02 08:31
 **/
public class MJCouponDiscount implements ICouponDiscount  {

    /**
     * 满减计算
     * 1. 判断满足 x元后 -n元，否则不减
     */
    @Override
    public BigDecimal discountAmount(Map<String,String> couponInfo, BigDecimal price) {
        BigDecimal coupon = new BigDecimal(couponInfo.get("coupon"));
        BigDecimal threshold = new BigDecimal(couponInfo.get("threshold"));

        // 商品价格小于满减阈值条件，直接返回商品原价
        if (price.compareTo(threshold) < 0) {
            return price;
        }
        // 减去优惠金额判断
        BigDecimal discountAmount = price.subtract(coupon);
        // 支付最小为 0元
        return BigDecimal.ZERO.max(discountAmount);
    }
}
