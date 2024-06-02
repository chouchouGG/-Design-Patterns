package cn.learn.Strategy;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description: 控制类主要是外部可以传递不同的策略实现，在通过统一的方法执行优惠策略计算。
 * @author: chouchouGG
 * @create: 2024-06-02 08:45
 **/
public class Context {

    private ICouponDiscount couponDiscount;

    public Context(ICouponDiscount couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal price) {
        return couponDiscount.discountAmount(couponInfo, price);
    }

}
