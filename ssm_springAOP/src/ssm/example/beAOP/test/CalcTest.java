package ssm.example.beAOP.test;

import ssm.example.beAOP.Calc;
import ssm.example.beAOP.impl.CalcImpl;
import ssm.example.beAOP.impl.CalcImplProxy;

/**
 * @author zls
 * @date 2021/9/30 15:34:49
 * @description 动态代理，单元测试
 */
public class CalcTest {
    public static void main(String[] args) {
        Calc calc = new CalcImpl();
        CalcImplProxy calcImplProxy = new CalcImplProxy(calc);
        Object proxy = calcImplProxy.getProxy();
        Calc calcProxy = (Calc) proxy;
        double add = calcProxy.add(1, 2);
    }
}
