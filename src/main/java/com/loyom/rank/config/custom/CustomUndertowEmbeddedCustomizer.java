package com.loyom.rank.config.custom;

import io.undertow.Undertow.Builder;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
* @ClassName: CustomUndertowEmbeddedCustomizer 
* @Description: TODO 定制undertow服务器 (也可以配置多个服务)
* @Company:esmart
* @author Thinkpad 
* @version 1.0 2017年12月21日 上午10:31:03
 */
@Configuration
@ConfigurationProperties(prefix = "undertow")
public class CustomUndertowEmbeddedCustomizer {

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
		factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
		
			@Override
			public void customize(Builder builder) {
				//这里可以配置多个端口服务，多个ip
				builder.addHttpListener(8080, "127.0.0.1");//http请求
				builder.addHttpListener(8081, "127.0.0.1");//http请求
				builder.addListener(8082, "127.0.0.1");
				//配置https请求 并添加SSL
//				builder.addHttpsListener(port, host, sslContext);
			}
		
		});
//		factory.setPort(8081);
		return factory;
	}
	
}
