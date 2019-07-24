package cn.edu.zju.community.Controller;

import cn.edu.zju.community.Provider.GithubProvider;
import cn.edu.zju.community.dto.AccessTokenDTO;
import cn.edu.zju.community.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by HChien Ying on 2019/7/24
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO ();
        accessTokenDTO.setClient_id("f0c80da9f3cf46df2f51");
        accessTokenDTO.setClient_secret ("9edf4de6453277a9ab84ba31d33c7b08613c7331");
        accessTokenDTO.setCode (code);
        accessTokenDTO.setRedirect_uri ("http://localhost:8887/callback");
        accessTokenDTO.setState (state);
        String accessToken = githubProvider.getAccessToken (accessTokenDTO);
        GithubUser githubUser = githubProvider.githubUser (accessToken);
        System.out.println (githubUser.getName ());
        githubProvider.getAccessToken (accessTokenDTO);
        return "index";
    }
}
