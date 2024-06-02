package cn.learn.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description: 折扣策略
 * @author: chouchouGG
 * @create: 2024-06-02 08:32
 **/
public class ZKCouponDiscount implements ICouponDiscount {

    /**
     * 折扣计算
     * 1. 使用商品价格乘以折扣比例，为最后支付金额
     * 2. 保留两位小数
     * 3. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal price) {
        BigDecimal coupon = new BigDecimal(couponInfo.get("coupon"));
        return price.multiply(coupon).setScale(2, RoundingMode.CEILING);
    }

}
