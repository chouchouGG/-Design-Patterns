package cn.learn;

import cn.learn.card.IQiYiCardService;
import cn.learn.coupon.CouponResult;
import cn.learn.coupon.CouponService;
import cn.learn.entity.AwardReq;
import cn.learn.goods.DeliverReq;
import cn.learn.goods.GoodsService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 模拟发奖服务
 *
 * @author 98389
 */
@Slf4j
public class PrizeController {

    public void awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);

        log.info("奖品发放开始{}。req:{}", req.getUId(), reqJson);

        // 按照不同类型方法商品【1优惠券、2实物商品、3第三方兑换卡(爱奇艺)】
        // note：需要使用工厂方法模式进行优化的地方
        if (req.getAwardType() == 1) {
            CouponService couponService = new CouponService();  // note：创建对象
            couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
        } else if (req.getAwardType() == 2) {
            GoodsService goodsService = new GoodsService();  // note：创建对象
            DeliverReq deliverReq = DeliverReq.builder()
                    .userNickName("joyboy")
                    .userPhone("123456789")
                    .sku(req.getAwardNumber())
                    .orderId(req.getBizId())
                    .consigneeUserName(req.getExtMap().get("consigneeUserName"))
                    .consigneeUserPhone(req.getExtMap().get("consigneeUserPhone"))
                    .consigneeUserAddress(req.getExtMap().get("consigneeUserAddress")).build();
            goodsService.deliverGoods(deliverReq);
        } else if (req.getAwardType() == 3) {
            IQiYiCardService iQiYiCardService = new IQiYiCardService();  // note：创建对象
            iQiYiCardService.grantCard("123456789", req.getAwardNumber());
        }

        log.info("奖品发放完成{}。", req.getUId());
    }

}