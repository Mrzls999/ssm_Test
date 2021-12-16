package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zls
 * @date 2021/12/16 14:28:19
 * @description XXX
 */
@Controller
public class EmployeeController {

    @RequestMapping(value = "emp_Controller")
    public String getAllEmployees(){

        return "empList";
    }

}
