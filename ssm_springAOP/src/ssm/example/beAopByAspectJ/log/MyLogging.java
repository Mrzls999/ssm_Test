package ssm.example.beAopByAspectJ.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zls
 * @date 2021/9/30 14:28:09
 * @description 数学计算的 日志解耦
 */
@Component
@Aspect
public class MyLogging {

//    @Pointcut(value = "execution(* *.*(..))")
    @Pointcut(value = "execution(* ssm.example.beAopByAspectJ.impl.*.*(..))")
    public void myPointCut() {}


    //@Before(value = "(execution(public double add(double, double))||(execution(public double div(double, double))))")
    public void methodBefore(JoinPoint joinPoint){//String methodName,Object[] args
        String methodName = joinPoint.getSignature().getName();//获得方法签名然后获取方法名字
        Object[] args = joinPoint.getArgs();
        System.out.println("===>执行"+methodName+"之前，参数："+ Arrays.toString(args));
    }

    //@AfterReturning(pointcut = "execution(public double ssm.example.beAopByAspectJ.impl.CalcImpl.add(double, double))",returning = "rs")
    public void methodAfter(JoinPoint joinPoint,Object rs){//String methodName,Object rs
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===>执行"+methodName+"之后，结果："+ rs.toString());
    }

    /**
     * 利用环绕通知 解决所有的通知
     * @param point
     * @return
     */
    @Around(value = "myPointCut()")
    public Object aroundMethod(ProceedingJoinPoint point){
        Object rs = null;
        String methodName = null;
        Object[] args = null;
        try {
            methodName = point.getSignature().getName();
            args = point.getArgs();
            //前置通知
            System.out.println("===>执行"+methodName+"之前，参数："+ Arrays.toString(args));
            rs = point.proceed();
            //返回通知
            System.out.println("===>执行"+methodName+"之后，结果："+ rs.toString());
        } catch (Throwable e) {
            e.printStackTrace();
            //异常通知
            System.out.println("==》日志：执行"+methodName+"出现异常之后执行，异常类型为,ex:" + e);
        } finally {
            //后置通知
            System.out.println("===>执行"+methodName+"之前，参数："+ Arrays.toString(args));
        }
        return rs;
    }
}
