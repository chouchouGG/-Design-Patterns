package cn.learn.Strategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description:
 * @author: chouchouGG
 * @create: 2024-06-02 08:26
 **/
public interface ICouponDiscount {

    /**
     * 优惠券金额计算
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return           优惠后金额
     */
    BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice);

}
