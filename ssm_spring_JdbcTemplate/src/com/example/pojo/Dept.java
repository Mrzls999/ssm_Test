package com.example.pojo;

/**
 * @author zls
 * @date 2021/9/2 9:42:24
 * @description 人员部门类
 */
public class Dept {
    private Integer id ;
    private String deptName ;

    public Dept() {
    }

    public Dept(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
