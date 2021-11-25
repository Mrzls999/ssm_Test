package com.example.dao.impl;

import com.example.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.dao.Dao_JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zls
 * @date 2021/11/25 15:28:31
 * @description XXX
 */
@Repository("Dao_JdbcTemplateImpl")
public class Dao_JdbcTemplateImpl implements Dao_JdbcTemplate {

//    /**
//     * 方式1.不加注解
//     * 在application_JdbcTemplate.xml中将Dao_JdbcTemplateImpl注入到spring容器中，并将JdbcTemplate作为属性添加进去
//     * 由于此种方式是set注入，所以加了set方法
//     */
//    private JdbcTemplate jdbcTemplate;

    /**
     * 方式2.加注解
     * 添加Autowired注解，使jdbcTemplate可以自动装配
     * 因为此时的Dao_JdbcTemplateImpl类类似于bean，那么需要在类处加@Repository("Dao_JdbcTemplateImpl"),也可以不指定引号里的名字
     * 并且在application_JdbcTemplate.xml中开启扫描器
     * 如果xxxx，那么使用Qualifier注解
     * 使用注解了，那么需要使用aop，不一定使用AspectJ
     */

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //Dao模式查询所有部门信息
    public List<Dept> getAllDept() {
        String sql = "select * from tbl_dept";
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
        System.out.println(jdbcTemplate);
        return jdbcTemplate.query(sql, rowMapper);
    }
}
