package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author zls
 * @date 2022/1/10 14:39:32
 * @description XXX
 */
@Controller
public class TestJson {

    @Qualifier("employeeDao")
    private final EmployeeDao employeeDao;

    @Autowired
    public TestJson(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * @ResponseBody：向浏览器端发送json数据，由于是ajax请求的，所以不用写视图名称【不用指定返回的地址】
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJson1")
    public Collection<Employee> testJson1(){
        return employeeDao.getAll();
    }

    /**
     * @ResponseBody：接受浏览器端发送json数据，由于是ajax请求的，所以不用写视图名称【不用指定返回的地址】
     * @return
     */
    @ResponseBody
    @RequestMapping("/testJson2")
    public Employee testJson2(@RequestBody Employee employee){
        System.out.println(employee);
        return employee;
    }
}
