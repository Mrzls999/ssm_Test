package ssm.example.beAOP;

/**
 * @author zls
 * @date 2021/9/16 9:40:41
 * @description XXX
 */
public interface Calc {

    /**
     * 加法
     * @param num1
     * @param num2
     * @return
     */
    double add(double num1,double num2);

    /**
     * 减法
     * @param num1
     * @param num2
     * @return
     */
    double sub(double num1,double num2);

    /**
     * 乘法
     * @param num1
     * @param num2
     * @return
     */
    double mul(double num1,double num2);

    /**
     * 除法
     * @param num1
     * @param num2
     * @return
     */
    double div(double num1,double num2);

}
