package ssm.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ssm.example.mapper.EmployeeMapper;
import ssm.example.pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeMapperTest {
    SqlSessionFactory build;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        build = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 查询所有员工信息，不包括部门信息
     */
    @Test
    public void selectEmployee(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    /**
     * 查询某员工信息，包括其部门信息 通过级联映射
     */
    @Test
    public void selectEmployeeById(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeById(1);
        System.out.println(employee);
    }

    /**
     * 查询某员工信息，包括其部门信息 通过association
     */
    @Test
    public void selectEmployeeByIdAssociation(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeByIdAssociation(2);
        System.out.println(employee);
    }

    /**
     * 查询某个部门下所有员工信息及部门信息
     */
    @Test
    public void selectEmployeeByDeptId(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeByDeptId(3);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     *分步，查询某个部门信息，及其员工信息
     */
    @Test
    public void selectEmployeeByStep(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeByStep(3);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * 懒加载
     */
    @Test
    public void selectEmployeeLazyLoad(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectEmployeeByStep(3);
        for (Employee employee : employees) {
            System.out.println(employee.getLastName());
        }
    }
}