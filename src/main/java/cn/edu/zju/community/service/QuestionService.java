package cn.edu.zju.community.service;

import cn.edu.zju.community.Mapper.QuestionMapper;
import cn.edu.zju.community.Mapper.UserMapper;
import cn.edu.zju.community.Model.Question;
import cn.edu.zju.community.Model.User;
import cn.edu.zju.community.dto.PaginationDTO;
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

    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO ();
        Integer totalCount = questionMapper.count ();
        paginationDTO.setPagination (totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage ()) {
            page = paginationDTO.getTotalPage ();
        }
        //5*(i-1)
        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list (offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<> ();
        for (Question question : questions) {
            User user = userMapper.findById (question.getCreator ());
            QuestionDTO questionDTO = new QuestionDTO ();
//            questionDTO.setId (question.getId ());
            BeanUtils.copyProperties (question, questionDTO);
            questionDTO.setUser (user);
            questionDTOList.add (questionDTO);
        }
        paginationDTO.setQuestions (questionDTOList);
        return paginationDTO;
    }
}
