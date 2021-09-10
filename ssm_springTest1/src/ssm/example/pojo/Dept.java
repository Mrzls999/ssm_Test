package ssm.example.pojo;

import org.springframework.stereotype.Component;

/**
 * @author zls
 * @date 2021/9/6 22:27:41
 * @description XXX
 */
@Component
public class Dept {
    private int id;
    private String deptName;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Dept() {
    }

    public Dept(int id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
