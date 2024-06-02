package cn.learn;

/**
 * @program: Design-Patterns
 * @description:
 * @author: chouchouGG
 * @create: 2024-06-02 13:09
 **/

import java.util.Map;

/**
 * 基础电商推广服务
 * 1. 生成最优价商品海报
 * 2. 海报含带推广邀请码
 */
public abstract class NetMall {

    String uId;   // 用户ID
    String uPwd;  // 用户密码

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * 生成商品推广海报
     * note：模板方法，用于给出整个流程的模板，不能被重写
     * @param skuUrl 商品地址(京东、淘宝、当当)
     * @return 海报图片base64位信息
     */
    public String generateGoodsPoster(String skuUrl) {
        // 1. 验证登录
        if (!login(uId, uPwd)) {
            return null;
        }
        // 2. 爬虫商品
        Map<String, String> reptile = reptile(skuUrl);
        // 3. 组装海报
        return createBase64(reptile);
    }

    // note：三个步骤方法，可以被重写，但如果给出了默认实现也可以使用默认实现
    // 模拟登录
    protected abstract Boolean login(String uId, String uPwd);

    // 爬虫提取商品信息(登录后的优惠价格)
    protected abstract Map<String, String> reptile(String skuUrl);

    // 生成商品海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);

}

