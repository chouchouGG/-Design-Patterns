package cn.learn.Strategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description: N 元购
 * @author: chouchouGG
 * @create: 2024-06-02 08:41
 **/
public class NYCouponDiscount implements ICouponDiscount {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal price) {
        return new BigDecimal(couponInfo.get("coupon"));
    }

}
