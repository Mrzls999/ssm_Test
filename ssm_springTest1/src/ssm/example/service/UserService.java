package ssm.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author zls
 * @date 2021/9/10 12:33:26
 * @description XXX
 */
public interface UserService {
    String getUserName(int id) throws IOException;
}
