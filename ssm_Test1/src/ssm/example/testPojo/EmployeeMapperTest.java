package ssm.example.testPojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ssm.example.mapper.EmployeeMapper;
import ssm.example.pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmployeeMapperTest {
    private EmployeeMapper mapper;
    private SqlSession session;//这个不能放在这，如果是多线程的话会有安全问题，数据库资源可能不会关闭，可以去官网的入门看
    /**
     * 测试方法之前
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(EmployeeMapper.class);//动态代理
        System.out.println("mapper.getClass().getName() = " + mapper.getClass().getName());
    }

    /**
     * 通过id查询一个Employee
     */
    @org.junit.Test
    public void selectEmployeeById() throws IOException {
        Employee employee = mapper.selectEmployeeById(1);//获取一个值
        System.out.println(employee);
    }

    /**
     * 查询所有
     */
    @org.junit.Test
    public void selectEmployees() throws IOException {
        List<Employee> employees = mapper.selectEmployees();//获取多个值
        System.out.println(employees);
    }

    /**
     * 添加一个Employee
     */
    @org.junit.Test
    public void addOneEmployee() {
        Employee employee = new Employee();//当你的数据是自增且id不重复时，这样就不用设置id字段，直接在数据库中自增了就
        employee.setLastName("zls");
        employee.setEmail("11.@163.com");
        employee.setGender("男");
        boolean isAdded = false;
        try {
            isAdded = mapper.addOneEmployee(employee);//这样就算出错，也不会宕机
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.commit();
        if(isAdded){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }

    /**
     * 删除Employee
     */
    @org.junit.Test
    public void deleteEmployeeById() {
        int id = 4;
        boolean isDeleted = false;
        try {
            isDeleted = mapper.deleteEmployeeById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.commit();
        if (isDeleted) {
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    /**
     * 修改Employee信息
     */
    @org.junit.Test
    public void updateEmployeeById() {
        Employee employee = new Employee();
        employee.setId(7);
        employee.setLastName("updatezls");
        employee.setEmail("zls@163.com");
        employee.setGender("女");
        boolean isUpdated = false;
        try {
            isUpdated = mapper.updateEmployeeById(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.commit();
        if(isUpdated){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    /**
     * 测试方法之后
     * @throws Exception
     */
    @org.junit.After
    public void tearDown() throws Exception {
    }
}