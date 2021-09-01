package ssm.example.mapper;

import ssm.example.pojo.Employee;

import java.util.List;

/**
 * @author zls
 * @date 2021/8/31 13:05:44
 * @description XXX
 */
public interface EmployeeMapper {
    Employee selectEmployeeById(int id);

    List<Employee> selectEmployees();
}
