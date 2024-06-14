package cn.learn.store;

/**
 * @program: Design-Patterns
 * @description:
 * @author: chouchouGG
 * @create: 2024-06-03 06:14
 **/
// note: 枚举 enum定义的类，默认继承 java.lang.Enum 类，枚举类中的成员默认是 public static final 的，且 enum类本身也是 final的。
//  枚举的成员就是定义的枚举类型的一个实例对象（Instance）。
public enum ServiceType {
    CARD,
    COUPON,
    GOODS;
}