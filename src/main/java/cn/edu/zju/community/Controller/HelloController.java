package cn.edu.zju.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by HChien Ying on 2019/7/23
 */

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "index";

    }
}
