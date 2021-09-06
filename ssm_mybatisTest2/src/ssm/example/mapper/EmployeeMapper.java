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
     * 查询所有员工信息，不包括部门信息
     * @return
     */
    List<Employee> selectEmployees();

    /**
     * 查询某员工信息，包括其部门信息
     * @return
     * @param i
     */
    Employee selectEmployeeById(int i);

    /**
     * 查询某员工信息，包括其部门信息 -->通过association
     * @return
     * @param i
     */
    Employee selectEmployeeByIdAssociation(int i);
    /**
     * 查询某个部门下所有员工信息及部门信息
     * @param i
     * @return
     */
    List<Employee> selectEmployeeByDeptId(int i);

    /**
     * 分步，查询某个部门信息，及其员工信息
     * 也用于懒加载试一下
     * @return
     * @param i
     */
    List<Employee> selectEmployeeByStep(int i);
}
