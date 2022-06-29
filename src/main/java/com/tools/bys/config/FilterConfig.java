package com.tools.bys.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequestFilter> registLogFilter() {
        FilterRegistrationBean logFilter = new FilterRegistrationBean();
        logFilter.setFilter(new RequestFilter());
        logFilter.addUrlPatterns("/*");
        logFilter.setOrder(1);
        return logFilter;
    }
}
