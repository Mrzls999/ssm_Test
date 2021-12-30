package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entities.Department;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
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

    private final ServletContext application;
    /**
     * 使用构造器注入，防止出现dao
     * @param employeeDao
     * @param departmentDao
     */
    @Autowired
    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao,ServletContext application){
        this.employeeDao=employeeDao;
        this.departmentDao=departmentDao;
        this.application = application;
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
        mav.setViewName("empList");//设置视图名
        return mav;
    }

    /**
     * 修改员工信息
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
     * 获取部门和性别信息
     * @param map
     * @return
     */
    @RequestMapping(value = "getDep",method = RequestMethod.GET)
    public String getAllDep(Map<String,Object> map, HttpSession session){
        //获取部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments",departments);
        /**
         * 此处发送到前端页面是request域，如果想放到session域可以这样做：
         * 在入参那的map后边getAllDep(Map<String,Object> map,HttpSession session)
         * session.setAttribute("departments",departments);
         * 如果想放到application域可以这样做：
         * （application域对应的后端是ServletContext域，整个应用只有一个，所以不能直接写在入参里边【如果写在里边相当于又创建了一个】）
         *方式1：通过session创建 ServletContext application = session.getServletContext();
         *方式2：通过springMVC自动注入进来，在属性的位置添加
         *      @Autowired
         *      private ServletContext application;
         *      方法中添加：
         *      application.setAttribute("departments",departments);
         */
        //存放性别信息
        HashMap<String, String> genders = new HashMap<>();
        genders.put("1","男");
        genders.put("0","女");
        map.put("genders",genders);
        map.put("employee",new Employee());
//        map.put("command",new Employee());
        return "input";
    }


    /**
     * 跳转到修改页面
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "goEditEmpView/{id}",method = RequestMethod.GET)
    public String goEditEmpView(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = employeeDao.get(id);
        //获取部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments",departments);
        //存放性别信息
        HashMap<String, String> genders = new HashMap<>();
        genders.put("1","男");
        genders.put("0","女");
        map.put("genders",genders);
        map.put("employee",employee);
        return "input";
    }


    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "saveEmp",method = RequestMethod.PUT)
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/getEmps";
    }

    /**
     * 利用get请求删除，此方式不是很好。可以利用ajax异步请求
     * @param id
     * @return
     */
    @RequestMapping(value="delEmp/{id}")
    public String delEmp(@PathVariable("id") String id){
        employeeDao.delete(Integer.valueOf(id));
        return "redirect:/getEmps";
    }
}
