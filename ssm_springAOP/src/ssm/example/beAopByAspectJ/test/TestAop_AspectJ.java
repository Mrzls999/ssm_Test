package ssm.example.beAopByAspectJ.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.example.beAOP.Calc;
import ssm.example.beAopByAspectJ.impl.CalcImpl;

/**
 * @author zls
 * @date 2021/10/8 9:23:52
 * @description XXX
 */
public class TestAop_AspectJ {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application_Aop.xml");

        /*
         * @Override
         * public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
         * 	 assertBeanFactoryActive();
         * 	 return getBeanFactory().getBean(name, requiredType);
         * }
         * 所以这个地方用的是，getBean("calcImpl", Calc.class);返回的是 接口类型 正好适合动态代理
         */
        Calc calc = applicationContext.getBean("calcImpl", Calc.class);//默认的规则，装配时byId的id是 类名首字母小写

        calc.add(1,2);
    }
}
