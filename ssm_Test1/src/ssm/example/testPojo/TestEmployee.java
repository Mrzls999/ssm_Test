package ssm.example.testPojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ssm.example.mapper.EmployeeMapper;
import ssm.example.pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zls
 * @date 2021/8/31 13:13:01
 * @description XXX
 */
public class TestEmployee {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);//动态代理
        System.out.println("mapper.getClass().getName() = " + mapper.getClass().getName());
        Employee employee = mapper.selectEmployeeById(2);//获取一个值
        List<Employee> employees = mapper.selectEmployees();//获取多个值
        System.out.println(employee);
        System.out.println(employees);
    }
}
