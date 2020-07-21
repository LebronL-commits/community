package life.study.lxj.mapper;

import life.study.lxj.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into qusetion (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtcreate},#{gmtmodified},#{creator},#{tag})")
    void  create(Question question);

    @Select("select * from qusetion limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select count(1) from qusetion")
    Integer count();
}
