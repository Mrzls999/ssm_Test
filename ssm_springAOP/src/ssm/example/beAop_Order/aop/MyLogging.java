package ssm.example.beAop_Order.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zls
 * @date 2021/9/30 14:28:09
 * @description 数学计算的 日志解耦
 */
@Component
@Aspect
@Order(value = 0)
public class MyLogging {

//    @Pointcut(value = "execution(* *.*(..))")
    //@Pointcut(value = "execution(* ssm.example.beAop_Order.impl.*.*(..))")
    public void myPointCut() {}


    @Before(value = "execution(* ssm.example.beAop_Order.impl.*.*(..))")
    public void methodBefore(JoinPoint joinPoint){//String methodName,Object[] args
        String methodName = joinPoint.getSignature().getName();//获得方法签名然后获取方法名字
        Object[] args = joinPoint.getArgs();
        System.out.println("===>执行"+methodName+"之前，参数："+ Arrays.toString(args));
    }

    //@AfterReturning(pointcut = "myPointCut()",returning = "rs")
    public void methodAfter(JoinPoint joinPoint,Object rs){//String methodName,Object rs
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===>执行"+methodName+"之后，结果："+ rs.toString());
    }
}
