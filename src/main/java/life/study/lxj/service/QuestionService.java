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

        Integer totalPage;

        if(totalcount%size == 0){
            totalPage = totalcount / size;
        }else{
            totalPage = totalcount / size+1;
        }

        if(page <1){
            page = 1;
        }
        if(page>totalPage){
            page = totalPage;
        }

        pageDto.setPagenation(totalPage, page);


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

    public PageDto list(Integer userId, Integer page, Integer size) {
        Integer totalcount = questionMapper.countByUserId(userId);
        PageDto pageDto = new PageDto();

        Integer totalPage;

        if(totalcount%size == 0){
            totalPage = totalcount / size;
        }else{
            totalPage = totalcount / size+1;
        }

        if(page <1){
            page = 1;
        }
        if(page>totalPage){
            page = totalPage;
        }

        pageDto.setPagenation(totalPage, page);
        Integer offset = size*(page-1);
        List<Question> questions = questionMapper.listByUserId(userId,offset,size);
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
