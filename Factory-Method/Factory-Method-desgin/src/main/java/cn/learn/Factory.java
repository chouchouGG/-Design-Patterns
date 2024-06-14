package cn.learn;


import cn.learn.store.ICommodity;
import cn.learn.store.ServiceType;
import cn.learn.store.impl.CardCommodityService;
import cn.learn.store.impl.CouponCommodityService;
import cn.learn.store.impl.GoodsCommodityService;

public class Factory {

    public ICommodity getCommodityService(ServiceType commodityType) {
        if (ServiceType.COUPON.equals(commodityType)) {
            return new CouponCommodityService();
        }
        if (ServiceType.GOODS.equals(commodityType)) {
            return new GoodsCommodityService();
        }
        if (ServiceType.CARD.equals(commodityType)) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }

}
