package sbwebtry.tliastry.mapper;

import org.apache.ibatis.annotations.*;
import sbwebtry.tliastry.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface Empmapper {
    @Select("select count(*) from emp")
    long getcount();

    @Select("select * from emp limit #{start},#{fin};")
    List<Emp> getall(Integer start,Integer fin);

    List<Emp> getlist(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values\n" +
            "(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getbyid(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(Emp emp);

    @Delete("delete from emp where dept_id = #{id}")
    void deletebydeptid(Integer id);
}
