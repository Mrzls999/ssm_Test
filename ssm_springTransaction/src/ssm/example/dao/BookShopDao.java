package ssm.example.dao;

/**
 * @author zls
 * @date 2021/11/30 15:05:41
 * @description 声明式事务dao层
 */
public interface BookShopDao {
    //1. 根据书号查询书的价格
    Integer findBookPriceByIsbn(String isbn );
    //2. 根据书号修改书的库存（需求：每次只能买一本书，如库存<=0，则抛出异常）
    void updateBookStock(String isbn);
    //3. 根据书的价格修改用户的余额(需求：如果余额不足，则抛出异常)
    void updateUserAccount(String username,Integer price );
}
