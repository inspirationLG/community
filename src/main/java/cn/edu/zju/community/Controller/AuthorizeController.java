package cn.edu.zju.community.Controller;

import cn.edu.zju.community.Provider.GithubProvider;
import cn.edu.zju.community.dto.AccessTokenDTO;
import cn.edu.zju.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HChien Ying on 2019/7/24
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value ("${github.client.id}")
    private String clientId;

    @Value ("${github.client.secret}")
    private String clientSecret;

    @Value ("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO ();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret (clientSecret);
        accessTokenDTO.setCode (code);
        accessTokenDTO.setRedirect_uri (redirectUri);
        accessTokenDTO.setState (state);
        String accessToken = githubProvider.getAccessToken (accessTokenDTO);
        GithubUser user = githubProvider.githubUser (accessToken);
//        System.out.println (githubUser.getName ());
//        githubProvider.getAccessToken (accessTokenDTO);
        if (user != null) {
            //登陆成功，写cookie和session
            request.getSession ().setAttribute ("user", user);
            return "redirect:/";
        }else {
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
}
