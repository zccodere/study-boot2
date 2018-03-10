package com.zccoder.boot2.ch3.mvc.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zccoder.boot2.ch3.mvc.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zc
 * @title 自定义WebMvcConfigurer类
 * @describe WebMvcConfigurer用来全局定制化 MVC 特性
 * @date 2018/03/09
 **/
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/user/**");
    }

    /**
     * 跨域访问配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // 允许所有跨域访问
        registry.addMapping("/**");

        // 或者更为精细的控制
        registry.addMapping("/api/**")
                .allowedOrigins("http://domain2.com")
                .allowedMethods("POST", "GET");
    }

    /**
     * 格式化
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));

    }

    /**
     * URL 到视图的映射
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("/index.btl");
        registry.addRedirectViewController("/**/*.do", "/index.html");
    }

    /**
     * 检查用户是否已经登录，如果未登录，重定向到登录页面
     */
    class SessionHandlerInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                response.sendRedirect("/login.html");
                return false;
            }
            return true;
        }
    }

}
