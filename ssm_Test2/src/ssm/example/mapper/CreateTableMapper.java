package ssm.example.mapper;

import org.apache.ibatis.annotations.Param;
import ssm.example.pojo.CreateTable;

import java.util.List;

/**
 * @author zls
 * @date 2021/9/3 16:59:50
 * @description XXX
 */
public interface CreateTableMapper {
    List<CreateTable> showCreateTables(@Param("tableNames") List<String> tableName);//这种方式是不行的，只能执行第一条sql，不行，可以变通一下，多次传入参数，不一次传入，多次执行这个方法
    CreateTable showCreateTable(@Param("tableName") String tableName);
}
