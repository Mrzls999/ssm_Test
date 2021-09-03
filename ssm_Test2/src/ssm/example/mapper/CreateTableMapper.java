package ssm.example.mapper;

import org.apache.ibatis.annotations.Param;
import ssm.example.pojo.CreateTable;

/**
 * @author zls
 * @date 2021/9/3 16:59:50
 * @description XXX
 */
public interface CreateTableMapper {
    CreateTable showCreateTable(@Param("tableName") String tableName);
}
