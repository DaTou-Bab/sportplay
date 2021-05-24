package com.tom.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration  //全局配置类--配置跨域请求（ Configuration说明该类是全局配置类 ）
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.请求访问路径
         * 2.请求来源
         * 3.请求方法
         * 4.允许携带
         * 5.响应最大时间
         */
        registry.addMapping("/**")  //跨域访问的东西
                .allowedOrigins("http://localhost:8080","null")  //跨域来源
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")//跨域方法
                .allowCredentials(true) //是否携带信息
                .maxAge(3600);  //最大响应时间
    }
}
