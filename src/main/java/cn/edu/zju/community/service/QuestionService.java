package cn.edu.zju.community.service;

import cn.edu.zju.community.Mapper.QuestionMapper;
import cn.edu.zju.community.Mapper.UserMapper;
import cn.edu.zju.community.Model.Question;
import cn.edu.zju.community.Model.User;
import cn.edu.zju.community.dto.QuestionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HChien Ying on 2019/7/28
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list ();
        List<QuestionDTO> questionDTOList = new ArrayList<> ();
        for (Question question : questions) {
            User user = userMapper.findById (question.getCreator ());
            QuestionDTO questionDTO = new QuestionDTO ();
//            questionDTO.setId (question.getId ());
            BeanUtils.copyProperties (question, questionDTO);
            questionDTO.setUser (user);
            questionDTOList.add (questionDTO);
        }
        return questionDTOList;
    }
}
