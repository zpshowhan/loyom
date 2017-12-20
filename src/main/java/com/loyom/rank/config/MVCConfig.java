package com.loyom.rank.config;

import com.loyom.rank.config.interceptor.AppVerifyAuthInterceptor;
import com.loyom.rank.config.interceptor.ChatHandshakeInterceptor;
import com.loyom.rank.config.interceptor.UserSecurityInterceptor;
import com.loyom.rank.config.interceptor.WebSocketHandshakeInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AppVerifyAuthInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new ChatHandshakeInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new WebSocketHandshakeInterceptor()).addPathPatterns("/**");
    }
    /**
     * 根目录指向index.html 
    * <p>Title: addViewControllers</p> 
    * <p>Description: </p> 
    * @param registry 
    * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
     */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addRedirectViewController("/","/index.html");
	    super.addViewControllers(registry);
	}
	/**
	 *  加载配置资源
	* <p>Title: addResourceHandlers</p> 
	* <p>Description: </p> 
	* @param registry 
	* @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/layim/**").addResourceLocations("classpath:/layim/");
//        super.addResourceHandlers(registry);
//    }
}
