package cn.edu.zju.community.Controller;

import cn.edu.zju.community.Mapper.UserMapper;
import cn.edu.zju.community.Model.User;
import cn.edu.zju.community.Provider.GithubProvider;
import cn.edu.zju.community.dto.AccessTokenDTO;
import cn.edu.zju.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by HChien Ying on 2019/7/24
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO ();
        accessTokenDTO.setClient_id (clientId);
        accessTokenDTO.setClient_secret (clientSecret);
        accessTokenDTO.setCode (code);
        accessTokenDTO.setRedirect_uri (redirectUri);
        accessTokenDTO.setState (state);
        String accessToken = githubProvider.getAccessToken (accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser (accessToken);
//        System.out.println (githubUser.getName ());
        if (githubUser != null && githubUser.getId () != null) {
            User user = new User ();
            String token = UUID.randomUUID ().toString ();
            user.setToken (token);
            user.setName (githubUser.getName ());
            user.setAccountId (String.valueOf (githubUser.getId ()));
            user.setGmtCreate (System.currentTimeMillis ());
            user.setGmtModified (user.getGmtModified ());
            userMapper.insert (user);
            response.addCookie (new Cookie ("token", token));
//            //登陆成功，写cookie和session
//            request.getSession ().setAttribute ("user", githubUser);
            return "redirect:/";
        } else {
            //登陆失败，重新登陆
            return "redirect:/";
        }
//        githubProvider.getAccessToken (accessTokenDTO);
    }
}
