package com.ares.ztserve.config;

import com.ares.ztserve.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ESy
 * @date 2023/2/23 023 9:24
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {
    private ExecutorService executorService = null;


    /**
     * 开启跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路由
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    private TokenInterceptor tokenInterceptor;

    //构造方法
    public CrosConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        executorService = new ThreadPoolExecutor(2,
                2,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(executorService));
        configurer.setDefaultTimeout(30000);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        //登录放行
                        "/login/**",
                        // 放行swagger相关的
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/v2/api-docs"
                );
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
