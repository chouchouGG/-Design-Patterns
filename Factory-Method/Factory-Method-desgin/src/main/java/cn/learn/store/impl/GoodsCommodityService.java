package cn.learn.store.impl;

import cn.learn.goods.DeliverReq;
import cn.learn.goods.GoodsService;
import cn.learn.store.ICommodity;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    private GoodsService goodsService = new GoodsService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        DeliverReq deliverReq = DeliverReq.builder()
                .userNickName("joyboy")
                .userPhone("123456789")
                .sku(commodityId)
                .orderId(bizId)
                .consigneeUserName(extMap.get("consigneeUserName"))
                .consigneeUserPhone(extMap.get("consigneeUserPhone"))
                .consigneeUserAddress(extMap.get("consigneeUserAddress")).build();

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", isSuccess);
    }

}
