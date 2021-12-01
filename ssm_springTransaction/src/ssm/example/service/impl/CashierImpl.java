package ssm.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssm.example.service.Cashier;
import ssm.example.service.Purchase;

import java.util.List;

/**
 * @author zls
 * @date 2021/12/1 15:25:03
 * @description XXX
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    @Qualifier("purchase")
    public Purchase purchase;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void checkOut(String username, List<String> isbns) {
        for (String isbn : isbns) {
            purchase.purchase(username,isbn);
        }
    }
}
