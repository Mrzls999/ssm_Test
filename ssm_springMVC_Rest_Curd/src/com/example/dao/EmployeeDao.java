package com.example.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.entities.Department;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;

	private final DepartmentDao departmentDao;

	/**
	 * @Autowired
	 * private DepartmentDao departmentDao;
	 *此处的变量注入，不能有效的指明依赖。相信很多人都遇见过一个bug，依赖注入的对象为null，在启动依赖容器时遇到这个问题都是配置的依赖注入少了一个注解什么的，然而这种方式就过于依赖注入容器了，当没有启动整个依赖容器时，这个类就不能运转，在反射时无法提供这个类需要的依赖。
	 *在使用set方式时，这是一种选择注入，可有可无，即使没有注入这个依赖，那么也不会影响整个类的运行。
	 *在使用构造器方式时已经显式注明必须强制注入。通过强制指明依赖注入来保证这个类的运行
	 */
	 @Autowired
	public EmployeeDao(DepartmentDao departmentDao){
		this.departmentDao = departmentDao;
	}


	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
	}
	
	private static Integer initId = 1006;

	/**
	 * 添加员工信息【或修改员工信息】
	 * 		判断员工id是否为null
	 * 			空：添加员工信息
	 * 			不为空：修改员工信息
	 * @param employee
	 */
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		//先通过员工的部门id，获取部门对象信息
		//再将部门对象，添加到员工对象中
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	/**
	 * 获取所有员工信息
	 * @return
	 */
	public Collection<Employee> getAll(){
		return employees.values();
	}

	/**
	 * 通过id获取员工信息
	 * @param id
	 * @return
	 */
	public Employee get(Integer id){
		return employees.get(id);
	}

	/**
	 * 删除员工信息
	 * @param id
	 */
	public void delete(Integer id){
		employees.remove(id);
	}
}
