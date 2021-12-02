package ssm.springMVC.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zls
 * @date 2021/12/2 9:23:07
 * @description XXX
 */
@Controller//标识当前类是一个请求处理器，注意：SpringMVC标识的请求处理器，必须使用@Controller
public class TestSpringMVC_HelloController {

    @RequestMapping(value="hello")
    public String hello_World(){
        System.out.println("===>helloController--->hello");
        return "success";
    }
}
