package cn.edu.zju.community.dto;

import cn.edu.zju.community.Model.User;
import lombok.Data;

/**
 * Created by HChien Ying on 2019/7/28
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;

}
