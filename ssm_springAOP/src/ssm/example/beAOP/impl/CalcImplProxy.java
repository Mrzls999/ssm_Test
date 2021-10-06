package ssm.example.beAOP.impl;

import ssm.example.beAOP.log.MyLogging;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zls
 * @date 2021/9/30 15:07:00
 * @description 自己实现动态代理
 */

public class CalcImplProxy {
    /**
     * 实现动态代理步骤
     * 1.定义被代理对象[目标对象]
     * 2.获取代理对象[中介]
     * 2.0 实现动态代理核心对象
     * 2.1 Proxy:代理类基类[类似java中的Object]
     * 2.2 InvocationHandler:实现代理对象目标方法[动态织入[作用]回到业务代码中]
     * 3.有参构造器（为了防止 被代理对象为空，这样就把空参构造覆盖了，这样在编写代码是，必须生成被代理对象）
     */
    //1.定义被代理对象[目标对象][房东]
    public Object target;//也可以写成，public CalcImpl target;

    public CalcImplProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        Object objProxy = null;//定义代理对象[中介]
        ClassLoader classLoader = target.getClass().getClassLoader();//被代理对象的类加载器
        Class<?>[] interfaces = target.getClass().getInterfaces();//被代理对象实现的接口
        //2.获取代理对象[中介]
        objProxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {//动态织入，作用到业务代码中
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();//获取方法名称
                MyLogging.methodBefore(name,args);//方法执行前织入日志
                Object rs = method.invoke(target, args);
                MyLogging.methodAfter(name,rs);//方法执行后织入日志
                return rs;
            }
        });
        return objProxy;
    }
}
