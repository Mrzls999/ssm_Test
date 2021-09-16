package ssm.example.beAOP.impl;

import ssm.example.beAOP.Calc;

/**
 * @author zls
 * @date 2021/9/16 10:28:42
 * @description XXX
 */
public class CalcImpl implements Calc {

    /**
     * 加
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double add(double num1, double num2) {
        return num1+num2;
    }
    /**
     * 加
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public double sub(double num1, double num2) {
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
        return num1/num2;
    }
}
