package ssm.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.example.annotation.excludeAnnotation;
import ssm.example.pojo.Employee;
/**
 * @author zls
 * @date 2021/9/6 9:30:54
 * @description XXX
 */
@excludeAnnotation
public class SpringTest {
    @Test
    public void testInit(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Employee bean = context.getBean("emp1",Employee.class);
        System.out.println(bean);
    }
}
