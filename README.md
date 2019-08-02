## The First Project
##资料<br>
[Spring 文档](https://spring.io/guides)  
[Spring Web 文档](https://spring.io/guides/gs/serving-web-content)  
[es社区](https://elasticsearch.cn/explore)  
[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)  
[BootStrap](v3.bootcss.com)  
[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)  
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)  


##工具<br>
[Git](https://git-scm.com/download)  
[Visual Paradigm](https://www.visual-paradigm.com/cn/)  
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  
[lombok](https://projectlombok.org/)  

##脚本  
'''
CREATE TABLE USER  
(  
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,  
    ACCOUNT_ID VARCHAR(100),  
    NAME VARCHAR(50),  
    TOKEN VARCHAR(36),  
    GMT_CREATE BIGINT,  
    GMT_MODIFIED BIGINT  
);
'''  
'''bash  
mvn flyway:migrate  
'''