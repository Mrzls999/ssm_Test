package ssm.example.beAOP.log;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author zls
 * @date 2021/9/30 14:28:09
 * @description 数学计算的 日志解耦
 */
public class MyLogging {

    public static void methodBefore(String methodName,Object[] args){
        System.out.println("===>执行"+methodName+"之前，参数："+ Arrays.toString(args));
    }

    public static void methodAfter(String methodName,Object rs){
        System.out.println("===>执行"+methodName+"之后，结果："+ rs.toString());
    }
}
