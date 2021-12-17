package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entities.Department;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;

/**
 * @author zls
 * @date 2021/12/16 14:28:19
 * @description XXX
 */
@Controller
public class EmployeeController {

    @Qualifier("employeeDao")
    private final EmployeeDao employeeDao;

    @Qualifier("departmentDao")
    private final DepartmentDao departmentDao;

    /**
     * 使用构造器注入，防止出现dao
     * @param employeeDao
     * @param departmentDao
     */
    @Autowired
    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao){
        this.employeeDao=employeeDao;
        this.departmentDao=departmentDao;
    }


    /**
     * 得到所有员工信息
     * @return
     */
    @RequestMapping(value = "getEmps",method = RequestMethod.GET)
    public ModelAndView getAllEmployees(){
        ModelAndView mav = new ModelAndView();
        Collection<Employee> empList = employeeDao.getAll();
        mav.addObject("empList",empList);
        mav.setViewName("empList");
        return mav;
    }

    /**
     * 保存员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "saveEmp",method = RequestMethod.POST)
    public String saveEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/getEmps";
    }

    /**
     * 获取部门信息
     * @param map
     * @return
     */
    @RequestMapping(value = "getDep",method = RequestMethod.GET)
    public String getAllDep(Map<String,Object> map){
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments",departments);
        return "input";
    }

}
