package cn.edu.zju.community.Model;

import lombok.Data;

@Data
/**
 * Created by HChien Ying on 2019/7/25
 */

public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(String accountId) {
//        this.accountId = accountId;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public Long getGmtCreate() {
//        return gmtCreate;
//    }
//
//    public void setGmtCreate(Long gmtCreate) {
//        this.gmtCreate = gmtCreate;
//    }
//
//    public Long getGmtModified() {
//        return gmtModified;
//    }
//
//    public void setGmtModified(Long gmtModified) {
//        this.gmtModified = gmtModified;
//    }
}
