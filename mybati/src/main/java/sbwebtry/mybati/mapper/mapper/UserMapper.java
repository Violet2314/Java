package sbwebtry.mybati.mapper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sbwebtry.mybati.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public List<User> list(Integer id);
}
