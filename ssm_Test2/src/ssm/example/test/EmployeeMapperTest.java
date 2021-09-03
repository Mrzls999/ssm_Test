package ssm.example.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * 分页，查询所有员工信息
     */
    @Test
    public void pageSelectAllEmployee(){
        SqlSession sqlSession = build.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        PageHelper.startPage(1,4);
        List<Employee> employees = mapper.selectEmployees();
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employees,3);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("当前页码：" + employeePageInfo.getPageNum());
        System.out.println("总页码：" + employeePageInfo.getPages());
        System.out.println("总数据条数：" + employeePageInfo.getTotal());
        System.out.println("每页显示条数：" + employeePageInfo.getPageSize());

        System.out.println("是否为第一页：" + employeePageInfo.isIsFirstPage());
        System.out.println("是否为最后一页：" + employeePageInfo.isIsLastPage());
        System.out.println("是否有上一页：" + employeePageInfo.isHasPreviousPage());
        System.out.println("是否有下一页：" + employeePageInfo.isHasNextPage());

        //获取分页业务逻辑
        int[] nums = employeePageInfo.getNavigatepageNums();
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}