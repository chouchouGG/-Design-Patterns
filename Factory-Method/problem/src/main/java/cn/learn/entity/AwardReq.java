package cn.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 奖品的请求
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardReq {

    // 用户唯一ID
    private String uId;
    // 奖品类型(可以用枚举定义)；1.优惠券，2.实物商品，3。第三方兑换卡(爱奇艺)
    private Integer awardType;
    // 奖品编号；sku、couponNumber、cardId
    private String awardNumber;
    // 业务ID，防重复
    private String bizId;
    // 扩展信息
    private Map<String, String> extMap;
}