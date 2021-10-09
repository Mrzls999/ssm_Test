package ssm.example.beAop_ByXML.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @author zls
 * @date 2021/9/30 14:28:09
 * @description 数学计算的 日志解耦
 */
public class MyLogging {

    //切入点表达式，此处使用xml配置，故没有用到
    public void myPointCut() {}

    //前置通知
    public void methodBefore(JoinPoint joinPoint){//String methodName,Object[] args
        String methodName = joinPoint.getSignature().getName();//获得方法签名然后获取方法名字
        Object[] args = joinPoint.getArgs();
        System.out.println("===>执行"+methodName+"之前，参数："+ Arrays.toString(args));
    }

    //后置通知
    public void methodAfter(JoinPoint joinPoint){//String methodName,Object rs
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===>执行"+methodName+"之后，后置通知：");
    }

    //返回通知
    public void methodAfterReturning(JoinPoint joinPoint,Object rs){//String methodName,Object rs
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===>执行"+methodName+"之后，返回通知：结果："+ rs.toString());
    }

    //异常通知
    public void methodAfterThrowing(JoinPoint joinPoint,Throwable ex){//String methodName,Object rs
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===>执行"+methodName+"之后，异常为："+ ex.toString());
    }

    //环绕通知
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
