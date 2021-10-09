package ssm.example.beAop_ByXML.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author zls
 * @date 2021/10/9 9:14:55
 * @description 计算器的校验 解耦
 */
@Component
@Aspect
@Order(value = 1)
public class CalcImpl_Verify {

    @Before(value = "execution(* ssm.example.beAop_Order.impl.*.*(..))")
    public void methodBeforeVVVV(JoinPoint joinPoint){
        System.out.println("===>执行校验之前");
    }

}
