package cn.edu.zju.community.Mapper;

import cn.edu.zju.community.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by HChien Ying on 2019/7/25
 */
@Mapper
public interface UserMapper {
    @Insert ("insert into user (name, account_id, token, gmt_create, gmt_modified) values (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insert(User user);
}
