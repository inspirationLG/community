package cn.edu.zju.community.controller;

import cn.edu.zju.community.dto.PaginationDTO;
import cn.edu.zju.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by HChien Ying on 2019/7/23
 */

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {

        PaginationDTO pagination = questionService.list (page, size);
//        for (QuestionDTO questionDTO : questionList) {
//            questionDTO.setDescription ("changed");
//        }
        model.addAttribute ("pagination", pagination);
        return "index";

    }
}
