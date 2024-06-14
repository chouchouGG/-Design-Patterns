import cn.learn.Factory;
import cn.learn.store.ICommodity;
import cn.learn.store.ServiceType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    private final Factory factory = new Factory();

    @Test
    public void test_card() {
        // 3. 第三方兑换卡(爱奇艺)
        ICommodity cardService = factory.getCommodityService(ServiceType.CARD);
        cardService.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }

    @Test
    public void test_coupon() {
        // 1. 优惠券
        ICommodity couponService = factory.getCommodityService(ServiceType.COUPON);
        couponService.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
    }

    @Test
    public void test_goods() {
        // 2. 实物商品
        ICommodity goodsService = factory.getCommodityService(ServiceType.GOODS);
        Map<String,String> extMap = new HashMap<>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        goodsService.sendCommodity("10001","9820198721311","1023000020112221113", extMap);
    }

}
