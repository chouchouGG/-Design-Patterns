package cn.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 98389
 * 奖品发放的响应结果
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardRes {

    // 编码
    private String code;
    // 描述
    private String info;

}