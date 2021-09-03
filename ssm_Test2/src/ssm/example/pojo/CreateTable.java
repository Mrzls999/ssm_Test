package ssm.example.pojo;

/**
 * @author zls
 * @date 2021/9/3 16:58:51
 * @description XXX
 */
public class CreateTable {
    private String table;
    private String CreateTable;

    @Override
    public String toString() {
        return "CreateTable{" +
                "table='" + table + '\'' +
                ", CreateTable='" + CreateTable + '\'' +
                '}';
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCreateTable() {
        return CreateTable;
    }

    public void setCreateTable(String createTable) {
        CreateTable = createTable;
    }

    public CreateTable(String table, String createTable) {
        this.table = table;
        CreateTable = createTable;
    }

    public CreateTable() {
    }
}
