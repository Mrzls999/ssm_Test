package ssm.example.beAop_ByXML.aop;

import org.aspectj.lang.JoinPoint;


/**
 * @author zls
 * @date 2021/10/9 9:14:55
 * @description 计算器的校验 解耦
 */
public class CalcImpl_Verify {
    public void methodBeforeV(JoinPoint joinPoint){
        System.out.println("===>执行校验");
    }
}
