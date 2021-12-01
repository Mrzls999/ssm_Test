package ssm.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.example.service.Cashier;
import ssm.example.service.Purchase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zls
 * @date 2021/11/30 15:26:22
 * @description 测试 spring的声明式事务
 */
public class Test_Spring_Declarative_Transaction {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void testTransactional(){
        Purchase purchase = context.getBean("purchase", Purchase.class);
//        purchaseImpl.purchase("Jerry","ISBN-001");//一次只买一本书
        //一次买3本，只要钱够就买，看看最后能买几本书
        purchase.purchase("Jerry","ISBN-001");
        purchase.purchase("Jerry","ISBN-002");
        purchase.purchase("Jerry","ISBN-001");
    }

    @Test //测试声明式事务的事务传播行为
    public void testTransactional_Propagation(){
        Cashier cashier = context.getBean("cashier", Cashier.class);
        List<String> isbns = new ArrayList<>();
        isbns.add("ISBN-001");
        isbns.add("ISBN-002");
        isbns.add("ISBN-001");
        cashier.checkOut("Jerry",isbns);
    }
}
