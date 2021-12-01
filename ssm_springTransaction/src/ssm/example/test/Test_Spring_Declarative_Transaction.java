package ssm.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssm.example.service.Purchase;

/**
 * @author zls
 * @date 2021/11/30 15:26:22
 * @description 测试 spring的声明式事务
 */
public class Test_Spring_Declarative_Transaction {

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Purchase purchaseImpl = context.getBean("purchaseImpl", Purchase.class);
//        purchaseImpl.purchase("Jerry","ISBN-001");//一次只买一本书
        //一次买3本，只要钱够就买，看看最后能买几本书
        purchaseImpl.purchase("Jerry","ISBN-001");
        purchaseImpl.purchase("Jerry","ISBN-002");
        purchaseImpl.purchase("Jerry","ISBN-001");
    }
}
