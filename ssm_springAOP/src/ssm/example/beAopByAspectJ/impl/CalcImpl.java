package ssm.example.beAopByAspectJ.impl;

import org.springframework.stereotype.Component;
import ssm.example.beAOP.Calc;

/**
 * @author zls
 * @date 2021/9/16 10:28:42
 * @description 加减乘除的实现
 */
@Component
public class CalcImpl implements Calc {

    /**
     * 加
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double add(double num1, double num2) {
        System.out.println("加法");
        return num1+num2;
    }
    /**
     * 减
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double sub(double num1, double num2) {
        System.out.println("减法");
        return num1-num2;
    }
    /**
     * 乘
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double mul(double num1, double num2) {
        System.out.println("乘法");
        return num1*num2;
    }
    /**
     * 除
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double div(double num1, double num2) {
        System.out.println("除法");
        return num1/num2;
    }
}
