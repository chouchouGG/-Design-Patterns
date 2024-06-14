package cn.learn.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 98389
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponResult {

    // 编码
    private String code;
    // 描述
    private String info;

}
