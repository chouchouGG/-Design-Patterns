package cn.learn.problems;

/**
 * @program: Design-Patterns
 * @description:
 * @author: chouchouGG
 * @create: 2024-06-02 05:13
 **/

/**
 * 优惠券折扣计算服务
 * 优惠券类型；1.直减券 2.满减券 3.折扣券 4.N元购
 */
public class CouponDiscountService {
    /**
     * 根据【商品价格】和【优惠券】，计算并返回优惠后的【商品价格】
     * @param type 优惠券类型
     * @param typeContent 优惠券金额
     * @param skuPrice Stock Keeping Units 存货单元的商品金额
     * @param typeExt 满减券或 N元购的优惠券面值
     * @return 返回优惠后的价格
     */
    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        // 1. 直减券
        if (1 == type) {
            return skuPrice - typeContent;
        }
        // 2. 满减券
        if (2 == type) {
            if (skuPrice < typeExt) {
                return skuPrice;
            }
            return skuPrice - typeContent;
        }
        // 3. 折扣券
        if (3 == type) {
            return skuPrice * typeContent;
        }
        // 4. n元购
        if (4 == type) {
            return typeContent;
        }
        return 0D;
    }

}

