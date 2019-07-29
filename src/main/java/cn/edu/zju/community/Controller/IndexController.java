package cn.edu.zju.community.Controller;

import cn.edu.zju.community.Mapper.UserMapper;
import cn.edu.zju.community.Model.User;
import cn.edu.zju.community.dto.QuestionDTO;
import cn.edu.zju.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by HChien Ying on 2019/7/23
 */

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        Model model) {
        Cookie[] cookies = request.getCookies ();
        if (cookies != null && cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName ().equals ("token")) {
                    String token = cookie.getValue ();
                    User user = userMapper.findByToken (token);
                    if (user != null) {
                        request.getSession ().setAttribute ("user", user);
                    }
                    break;
                }
            }

        List<QuestionDTO> questionList = questionService.list ();
        model.addAttribute ("question", questionList);
        return "index";

    }
}
