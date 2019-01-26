package com.sust.appinfo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置拦截器
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         * 不止One，还有Two，Three
         */
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/dev/*").
                excludePathPatterns("/manager/*").excludePathPatterns("/statics/**").excludePathPatterns("/register/**");

        super.addInterceptors(registry);
    }

}
