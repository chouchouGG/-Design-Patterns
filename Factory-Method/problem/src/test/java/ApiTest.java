import cn.learn.entity.AwardReq;
import cn.learn.PrizeController;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ApiTest {

    public static PrizeController prizeController = null;

    /**
     * 初始化奖品发放的控制器：可以
     */
    @BeforeClass
    public static void test_init_PrizeController() {
        prizeController = new PrizeController();
    }

    @Test
    public void test_card() {
        // 模拟发放兑换卡(爱奇艺)
        log.info("模拟发放兑换卡(爱奇艺)");
        AwardReq req03 = AwardReq.builder()
                .uId("10001")
                .awardType(3) // note：设置奖品类型
                .awardNumber("AQY1xjkUodl8LO975GdfrYUio").build();

        prizeController.awardToUser(req03);
        log.info("测试完毕");
    }

    @Test
    public void test_coupon() {
        log.info("模拟发放优惠券测试");
        // 模拟发放优惠券测试
        AwardReq req01 = AwardReq.builder()
                .uId("10001")
                .awardType(1) // note：设置奖品类型
                .awardNumber("EGM1023938910232121323432")
                .bizId("791098764902132").build();
        prizeController.awardToUser(req01);
        log.info("测试完毕");
    }

    @Test
    public void test_goods() {
        // 模拟发放实物商品
        log.info("模拟发放实物商品");
        Map<String, String> extMap = new HashMap<String, String>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");

        AwardReq req02 = AwardReq.builder()
                .uId("10001")
                .awardType(2) // note：设置奖品类型
                .awardNumber("9820198721311")
                .bizId("1023000020112221113")
                .extMap(extMap).build();

        prizeController.awardToUser(req02);
        log.info("测试完毕");
    }

}