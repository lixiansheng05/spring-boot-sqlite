package com.tsinghuan.springbootsqlite.common.swagger;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {


    /**
     * 是否开启swagger
     */
    private Boolean enabled;

    /**
     * 标题
     **/
    private String title = "";

    /**
     * 版本
     **/
    private String version = "";
}