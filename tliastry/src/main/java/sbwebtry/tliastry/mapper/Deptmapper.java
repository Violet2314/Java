package sbwebtry.tliastry.mapper;

import org.apache.ibatis.annotations.*;
import sbwebtry.tliastry.pojo.Dept;

import java.util.List;

@Mapper
public interface Deptmapper {
    @Select("select * from dept")
    List<Dept> getall();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into  dept(name, create_time, update_time)\n" +
            "values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Update("update dept set update_time = #{updateTime},name = #{name} where id = #{id};")
    void update(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getbyid(Integer id);
}
