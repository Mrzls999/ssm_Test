package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author zls
 * @date 2021/12/16 14:28:19
 * @description XXX
 */
@Controller
public class EmployeeController {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }


    @RequestMapping(value = "emp_Controller")
    public ModelAndView getAllEmployees(){
        ModelAndView mav = new ModelAndView();
        Collection<Employee> empList = employeeDao.getAll();
        mav.addObject("empList",empList);
        mav.setViewName("empList");
        return mav;
    }

}
