import cn.learn.NetMall;
import cn.learn.group.JDNetMall;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @program: Design-Patterns
 * @description:
 * @author: chouchouGG
 * @create: 2024-06-02 13:35
 **/

@Slf4j
public class TemplateMethodTest {
    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        log.info("测试结果：{}", base64);
    }
}
