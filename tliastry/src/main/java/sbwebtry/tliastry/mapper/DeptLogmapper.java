package sbwebtry.tliastry.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sbwebtry.tliastry.pojo.DeptLog;

@Mapper
public interface DeptLogmapper {
    @Insert("insert into dept_log (create_time, description)\n" +
            "values (#{createTime},#{description});")
    void insert(DeptLog deptLog);
}
