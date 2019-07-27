package cn.edu.zju.community.Mapper;

import cn.edu.zju.community.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by HChien Ying on 2019/7/26
 */
@Mapper
public interface QuestionMapper {
    @Insert ("insert into question (title, description, gmt_create, gmt_modified, creator, tag) values (#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    void create(Question question);
}
