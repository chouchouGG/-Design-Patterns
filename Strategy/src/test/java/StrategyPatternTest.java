import cn.learn.Strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Design-Patterns
 * @description:
 * @author: chouchouGG
 * @create: 2024-06-02 09:01
 **/
@Slf4j
public class StrategyPatternTest {

    @Test
    public void test_zj() {
        // 直减10元，商品100元
        Context context = new Context(new ZJCouponDiscount());
        Map<String, String> couponInfo = new HashMap<String, String>();
        couponInfo.put("coupon", "10");
        BigDecimal discountAmount = context.discountAmount(couponInfo, new BigDecimal(100));
        log.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_mj() {
        // 满100减20，商品100元
        Context context = new Context(new MJCouponDiscount());
        Map<String, String> couponInfo = new HashMap<String, String>();
        couponInfo.put("coupon", "20");
        couponInfo.put("threshold", "100");
        BigDecimal discountAmount = context.discountAmount(couponInfo, new BigDecimal(100));
        log.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_zk() {
        // 折扣9折，商品100元
        Context context = new Context(new ZKCouponDiscount());
        Map<String, String> couponInfo = new HashMap<String, String>();
        couponInfo.put("coupon", "0.9");
        BigDecimal discountAmount = context.discountAmount(couponInfo, new BigDecimal(100));
        log.info("测试结果：折扣9折后金额 {}", discountAmount);
    }

    @Test
    public void test_ny() {
        // n元购；100-10，商品100元
        Context context = new Context(new NYCouponDiscount());
        Map<String, String> couponInfo = new HashMap<String, String>();
        couponInfo.put("coupon", "10");
        BigDecimal discountAmount = context.discountAmount(couponInfo, new BigDecimal(100));
        log.info("测试结果：n元购优惠后金额 {}", discountAmount);
    }
}
