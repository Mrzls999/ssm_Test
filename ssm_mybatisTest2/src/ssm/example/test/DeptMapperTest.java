package ssm.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ssm.example.mapper.CreateTableMapper;
import ssm.example.mapper.DeptMapper;
import ssm.example.pojo.CreateTable;
import ssm.example.pojo.Dept;

import java.io.InputStream;

public class DeptMapperTest {
    SqlSessionFactory build;
    @Before
    public void setUp() throws Exception {
        String source = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(source);
        build = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectDeptById() {
        SqlSession sqlSession = build.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.selectDeptById(1);
        System.out.println(dept);
    }

    @Test
    public void showCreateTable() {
        SqlSession sqlSession = build.openSession();
        CreateTableMapper mapper = sqlSession.getMapper(CreateTableMapper.class);
        CreateTable tbl_dept = mapper.showCreateTable("tbl_employee");
        System.out.println(tbl_dept);
        //这样只能执行第一条sql，不行，可以变通一下，多次传入参数，不一次传入，多次执行这个方法
//        List<String> tableNames = new ArrayList<>();
//        tableNames.add("tbl_employee");
//        tableNames.add("tbl_dept");
//        List<CreateTable> createTables = mapper.showCreateTables(tableNames);
//        for (CreateTable createTable : createTables) {
//            System.out.println(createTable);
//        }
    }
}