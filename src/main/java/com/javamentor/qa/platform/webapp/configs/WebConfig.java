package com.javamentor.qa.platform.webapp.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/regPage").setViewName("regPage");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/usersPage").setViewName("usersPage");
        registry.addViewController("/question").setViewName("question");
        registry.addViewController("/questions").setViewName("questions");
        registry.addViewController("/login").setViewName("loginPage");
    }
}
