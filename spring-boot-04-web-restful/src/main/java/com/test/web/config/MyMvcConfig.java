package com.test.web.config;


import com.test.web.component.LoginHandlerInterceptor;
import com.test.web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description
 *
 * @author 24360 2019/08/27 11:04
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/xixihuahua").setViewName("success");
        registry.addViewController("/haha").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 拦截器设置
         /*   @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login" , "/login.html","static/**" ,"webjars/**") ;
            }*/
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
