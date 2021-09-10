package ssm.example.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.example.mapper.DeptMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zls
 * @date 2021/9/10 12:33:42
 * @description XXX
 */
@Service
public class UserServiceImpl implements UserService {
    String resource = "mybatis-conf.xml";

    @Override
    public String getUserName(int id) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        return mapper.getUserName(id);
    }
}
