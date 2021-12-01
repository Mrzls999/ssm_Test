package ssm.example.service;

import java.util.List;

/**
 * @author zls
 * @date 2021/12/1 11:09:50
 * @description XXX
 */
public interface Cashier {
    void checkOut(String username, List<String> isbns );
}
