package com.example.test;

import com.example.dao.impl.Dao_JdbcTemplateImpl;
import com.example.pojo.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author zls
 * @date 2021/11/25 14:10:04
 * @description XXX
 */
public class Test_JdbcTemplate {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application_JdbcTemplate.xml");
    JdbcTemplate jdbcTemplateDataSource = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test
    //测试通过xml获取JdbcTemplate
    public void test_getJdbcTemplateByXml() {
        System.out.println(jdbcTemplateDataSource);
    }

    @Test
    //测试JdbcTemplate的修改
    public void test_JdbcTemplate_Update() {
        String sql = "update tbl_dept set dept_name=? where id = ?";
        //update() 方法 适用于增删改
        //batchUpdate() 方法 适用于 批量的增删改
        int num = jdbcTemplateDataSource.update(sql, "我嫩爹", 12);
        System.out.println("影响的行数：" + num);
    }

    @Test
    //查询单个值&单个对象
    public void querySingle() {
        String sql = "select dept_name from tbl_dept where id=?";
        String dept_name = jdbcTemplateDataSource.queryForObject(sql, String.class, 1);
        System.out.println(dept_name);
    }

    @Test
    //查询多个
    public void querySome() {
        String sql = "select * from tbl_dept";
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
        List<Dept> query = jdbcTemplateDataSource.query(sql, rowMapper);
        for (Dept dept : query) {
            System.out.println(dept);
        }
    }

    @Test
    //Dao模式查询所有部门信息
    public void test_Dao_QueryAllDept() {
        //由于是由spring容器提供对象，所以不能这样获取
        //List<Dept> allDept = new Dao_JdbcTemplateImpl().getAllDept();
        //方式1：通过xml配置
        //Dao_JdbcTemplateImpl jdbcTemplate = applicationContext.getBean("dao_jdbcTemplate", Dao_JdbcTemplateImpl.class);
        //方式2：通过注解
        Dao_JdbcTemplateImpl jdbcTemplate = applicationContext.getBean("Dao_JdbcTemplateImpl", Dao_JdbcTemplateImpl.class);
        List<Dept> allDept = jdbcTemplate.getAllDept();
        for (Dept dept : allDept) {
            System.out.println(dept);
        }
    }

}
