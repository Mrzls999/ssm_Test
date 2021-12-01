package ssm.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ssm.example.dao.BookShopDao;
import ssm.example.dao.impl.BookShopDaoImpl;
import ssm.example.service.Purchase;

/**
 * @author zls
 * @date 2021/11/30 15:08:39
 * @description XXX
 */
@Service("purchase")
public class PurchaseImpl implements Purchase {

    @Autowired
    @Qualifier("bookShopDao")
    public BookShopDao bookShopDao;

    @Override
    //买书->查询book价格->修改库存->修改余额
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void purchase(String username, String isbn) {
        Integer bookPriceByIsbn = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,bookPriceByIsbn);
    }
}
