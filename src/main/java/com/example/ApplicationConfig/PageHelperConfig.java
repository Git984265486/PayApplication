package com.example.ApplicationConfig;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis分页插件配置
 * **/
@Configuration
public class PageHelperConfig {

    @Bean

    public PageHelper getPageHelper(){

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        // 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
        properties.setProperty("offsetAsPageNum", "true");

        //设置为true时，使用RowBounds分页会进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");

        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
