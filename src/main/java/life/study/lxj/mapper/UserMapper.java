package life.study.lxj.mapper;

import life.study.lxj.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{accountid},#{name},#{token},#{gmtcreate},#{gmtmodified},#{avatarurl})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findbytoken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User findbyId(@Param("id") Integer id);
}
