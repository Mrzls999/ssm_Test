package ssm.example.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import ssm.example.service.UserService;

import java.io.IOException;

/**
 * @author zls
 * @date 2021/9/10 12:29:08
 * @description XXX
 */
@Controller("userController")
public class UserServlet {
    @Autowired(required = true)
    @Qualifier("userServiceImpl1")
    private UserService userServiceImpl;
    /**
     * 得到用户性名
     */
    public void getUserName(){
        try {
            String userName = userServiceImpl.getUserName(1);
            System.out.println(userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void init(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserServlet userController = applicationContext.getBean("userController", UserServlet.class);
        userController.getUserName();
    }
}
