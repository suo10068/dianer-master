package com.dianer.config;

import com.dianer.util.FreemarkerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * @Program: dianer-study
 * @Description:
 * @Author: SLY
 * @Date: 2020-07-22 16:18
 **/
@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean() {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }

    @Bean
    public FreemarkerUtil freemarkerUtil() {
        FreemarkerUtil freemarkerUtil = new FreemarkerUtil();
        freemarker.template.Configuration configuration = freeMarkerConfigurationFactoryBean().getObject();
        freemarkerUtil.setConf(configuration);
        return freemarkerUtil;
    }

}
