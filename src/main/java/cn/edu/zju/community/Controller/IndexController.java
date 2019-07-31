package cn.edu.zju.community.Controller;

import cn.edu.zju.community.Mapper.UserMapper;
import cn.edu.zju.community.Model.User;
import cn.edu.zju.community.dto.PaginationDTO;
import cn.edu.zju.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
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
        PaginationDTO pagination = questionService.list (page, size);
//        for (QuestionDTO questionDTO : questionList) {
//            questionDTO.setDescription ("changed");
//        }
        model.addAttribute ("questions", pagination);
        return "index";

    }
}
