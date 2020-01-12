package com.dianer.bigdata.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 统一属性控制类，获取配置文件属性
 * @author dianer
 * @Date 2019年5月18日
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = DataSourceProperties.DS, ignoreUnknownFields = false)
public class DataSourceProperties {

    final static String DS = "spring.datasource";

    private Map<String,String> hive;

    private Map<String,String> commonConfig;


    /*为节省空间，这里省略set和get方法，需自行添加上去*/

}