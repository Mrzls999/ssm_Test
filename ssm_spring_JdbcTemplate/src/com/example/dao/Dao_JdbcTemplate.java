package com.example.dao;

import com.example.pojo.Dept;

import java.util.List;

/**
 * @author zls
 * @date 2021/11/25 15:26:57
 * @description XXX
 */
public interface Dao_JdbcTemplate {

    //Dao模式查询所有部门信息
    List<Dept> getAllDept();

}
