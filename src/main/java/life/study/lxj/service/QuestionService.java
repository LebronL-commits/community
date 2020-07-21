package life.study.lxj.service;

import life.study.lxj.dto.PageDto;
import life.study.lxj.dto.QuestionDto;
import life.study.lxj.mapper.QuestionMapper;
import life.study.lxj.mapper.UserMapper;
import life.study.lxj.model.Question;
import life.study.lxj.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired(required = false)
    private QuestionMapper questionMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    public PageDto list(Integer page, Integer size) {
        Integer totalcount = questionMapper.count();
        PageDto pageDto = new PageDto();
        pageDto.setPagenation(totalcount, page, size);

        if(page <1){
            page = 1;
        }
        if(page>pageDto.getTotalPage()){
            int x = pageDto.getTotalPage();
            page = x;
        }
        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findbyId(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }
        pageDto.setQuestion(questionDtoList);
        return pageDto;
    }
}
