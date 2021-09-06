package ssm.example.mapper;

import ssm.example.pojo.Employee;

import java.util.List;

/**
 * @author zls
 * @date 2021/8/31 13:05:44
 * @description XXX
 */
public interface EmployeeMapper {
    /**
     * 根据id查找一个人
     * @param id
     * @return
     */
    Employee selectEmployeeById(int id);

    /**
     * 查找所有
     * @return
     */
    List<Employee> selectEmployees();

    /**
     * 添加一个人
     */
    boolean addOneEmployee(Employee employee);

    /**
     * 删除一个人
     */
    boolean deleteEmployeeById(int id);

    /**
     * 修改一个人的信息
     */
    boolean updateEmployeeById(Employee employee);
}
