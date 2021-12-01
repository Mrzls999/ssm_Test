package ssm.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ssm.example.dao.BookShopDao;

import java.math.BigDecimal;

/**
 * @author zls
 * @date 2021/11/30 15:06:56
 * @description XXX
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    public JdbcTemplate jdbcTemplate;

    @Override
    //1. 根据书号查询书的价格
    public Integer findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    //2. 根据书号修改书的库存（需求：每次只能买一本书，如库存<=0，则抛出异常）
    public void updateBookStock(String isbn) {
        String sql_updateStock = "update book_stock set stock=stock-1 where isbn=?";
        String sql_count = "select count(1) from book_stock where isbn=?";
        Integer book_stock = jdbcTemplate.queryForObject(sql_count, Integer.class, isbn);
        if(book_stock==null||book_stock<=0){
            throw new RuntimeException("编号为："+isbn+"的图书数量不够了");
        }//此处抛出异常，则不往下执行了
        jdbcTemplate.update(sql_updateStock,isbn);
    }

    @Override
    //3. 根据书的价格修改用户的余额(需求：如果余额不足，则抛出异常)
    public void updateUserAccount(String username, Integer price) {
        String sql_queryBalance = "select balance from account where username=?";//查询余额的sql
        BigDecimal balance = jdbcTemplate.queryForObject(sql_queryBalance, BigDecimal.class, username);//查询余额
        if(balance==null || balance.compareTo(BigDecimal.valueOf(price))<0){
            throw new RuntimeException(username+"的余额不足了");
        }
        String sql_updateUserBalance = "update account set balance = balance-? where username=?";
        jdbcTemplate.update(sql_updateUserBalance,price,username);
    }
}
