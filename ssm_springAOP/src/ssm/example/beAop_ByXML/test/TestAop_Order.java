package ssm.example.beAop_ByXML.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.example.beAop_ByXML.Calc;

/**
 * @author zls
 * @date 2021/10/8 9:23:52
 * @description XXX
 */
public class TestAop_Order {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application_Aop_ByXML.xml");
        Calc calc = applicationContext.getBean("calcImpl", Calc.class);//默认的规则，装配时byId的id是 类名首字母小写
        calc.add(1,2);
    }
}
