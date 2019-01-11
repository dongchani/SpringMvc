package com.app;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.channels.Pipe;

@Component
@Data
/*配置属性文件*/
public class PropertiesConfig {

    @Value("${spring.datasource.driverClassName}")
    private  String driverClassName;
    @Value("${spring.datasource.url}")
    private  String url;
    @Value("${spring.datasource.user}")
    private  String user;
    @Value("${spring.datasource.password}")
    private  String password;
   @Value("${mybatis.mapper.location}")
   private String  mapperlocation;
    @Value("${mybatisTypeAlias}")
    private String mybatisTypeAliases;
    @Value("${mybatisPlugins}")
    private  String  mybatisPlugins;

    public Integer getMaxFileUpload() {
        return maxFileUpload;
    }

    public void setMaxFileUpload(Integer maxFileUpload) {
        this.maxFileUpload = maxFileUpload;
    }

    @Value("${spring.web.upload.maxUpload}")
   private  Integer maxFileUpload;

}
