package ssm.example.service;

/**
 * @author zls
 * @date 2021/11/30 15:08:12
 * @description XXX
 */
public interface Purchase {
    //买书->查询book价格->修改库存->修改余额
    void purchase(String username, String isbn );
}
