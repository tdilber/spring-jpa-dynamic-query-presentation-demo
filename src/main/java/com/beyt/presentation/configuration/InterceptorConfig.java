package com.beyt.presentation.configuration;

import com.beyt.presentation.interceptor.DatabaseSelectionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(databaseSelectionInterceptor());
    }

    @Bean
    public DatabaseSelectionInterceptor databaseSelectionInterceptor() {
        return new DatabaseSelectionInterceptor();
    }
}
