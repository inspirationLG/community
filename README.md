## The First Project
##资料<br>
[Spring 文档](https://spring.io/guides)<br>
[Spring Web 文档](https://spring.io/guides/gs/serving-web-content)<br>
[es社区](https://elasticsearch.cn/explore)<br>
[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)<br>
[BootStrap](v3.bootcss.com)<br>
[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)<br>
[spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)<br>


##工具<br>
[Git](https://git-scm.com/download)<br>
[Visual Paradigm](https://www.visual-paradigm.com/cn/)<br>
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)<br>


##脚本<br>
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