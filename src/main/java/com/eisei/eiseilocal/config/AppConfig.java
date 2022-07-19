package com.eisei.eiseilocal.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author jesus.hernandez
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class AppConfig implements WebMvcConfigurer {
    
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pmc) {
        
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer cnc) {
        
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asc) {
        
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer dshc) {
        
    }

    @Override
    public void addFormatters(FormatterRegistry fr) {
        
    }

    @Override
    public void addInterceptors(InterceptorRegistry ir) {
        
    }

    @Override
    public void addCorsMappings(CorsRegistry cr) {
        
    }

    @Override
    public void addViewControllers(ViewControllerRegistry vcr) {
        
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry vrr) {
        
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
        
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
        
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {
        
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {
        
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {
        
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {
        
    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
    
}
