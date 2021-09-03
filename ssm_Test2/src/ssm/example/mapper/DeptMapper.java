package ssm.example.mapper;

import ssm.example.pojo.Dept;

import java.util.List;

/**
 * @author zls
 * @date 2021/9/2 13:25:04
 * @description 部门信息表
 */
public interface DeptMapper {
    Dept selectDeptById(int id);
}
