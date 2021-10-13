package ssm.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zls
 * @date 2021/10/13 16:46:07
 * @description XXX
 */
public class TestJdbcTemplate {
    @Test
    public void testJdbcTemplateInit(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationJdbcTemplate.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println("jdbcTemplate"+jdbcTemplate);
    }
}
