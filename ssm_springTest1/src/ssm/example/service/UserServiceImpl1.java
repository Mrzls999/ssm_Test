package ssm.example.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author zls
 * @date 2021/9/10 15:00:49
 * @description XXX
 */
@Service//("userServiceImpl1")
public class UserServiceImpl1 implements UserService{
    @Override
    public String getUserName(int id) throws IOException {
        return "xxx";
    }
}
