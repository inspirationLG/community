package cn.edu.zju.community.Provider;

import cn.edu.zju.community.dto.AccessTokenDTO;
import cn.edu.zju.community.dto.GithubUser;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by HChien Ying on 2019/7/24
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString (accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body ().string ();
            String[] split = string.split ("&");
            String tokenstr = split[0];
            String token = tokenstr.split ("=")[1];
            return token;
//            System.out.println (string);
//            return string;
        } catch (IOException e) {
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body ().string ();
            GithubUser githubUser = JSON.parseObject (string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            return null;

        }
    }
}
