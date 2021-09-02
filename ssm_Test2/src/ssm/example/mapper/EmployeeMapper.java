package ssm.example.mapper;

import ssm.example.pojo.Employee;

import java.util.List;

/**
 * @author zls
 * @date 2021/9/2 9:57:25
 * @description XXX
 */
public interface EmployeeMapper {
    /**
     * 查询所有Employee
     * @return
     */
    List<Employee> selectEmployee();
}
