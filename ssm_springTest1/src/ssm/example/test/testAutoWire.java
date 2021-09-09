package ssm.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.example.pojo.Employee;

/**
 * @author zls
 * @date 2021/9/6 22:52:17
 * @description XXX
 */
public class testAutoWire {
    @Test
    public void testAutoWire1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Employee emp1 = context.getBean("emp1", Employee.class);
        System.out.println("emp1 = " + emp1);
    }
}
