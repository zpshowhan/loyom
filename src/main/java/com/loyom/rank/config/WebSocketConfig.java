package com.loyom.rank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.loyom.rank.config.interceptor.ChatHandshakeInterceptor;
import com.loyom.rank.config.interceptor.WebSocketHandshakeInterceptor;
import com.loyom.rank.websocket.ChatWebSocketHandler;
import com.loyom.rank.websocket.GameHandler;

@Configuration
//@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub

		 // 允许连接的域,只能以http或https开头
        String[] allowsOrigins = {"http://127.0.0.1:1213", "http://localhost:1213"};
        registry.addHandler(gameHandler(),"/game").addInterceptors(handshakeInterceptor()).setAllowedOrigins(allowsOrigins);
        registry.addHandler(chatWebSocketHandler(),"/webSocketIMServer").setAllowedOrigins(allowsOrigins).addInterceptors(chatHandshakeInterceptor());
        registry.addHandler(chatWebSocketHandler(), "/sockjs/webSocketIMServer").setAllowedOrigins(allowsOrigins).addInterceptors(chatHandshakeInterceptor()).withSockJS();
	}

	@Bean
    public GameHandler gameHandler() {
        return new GameHandler();
    }
	
    @Bean
    public ChatWebSocketHandler chatWebSocketHandler() {
        return new ChatWebSocketHandler();
    }
	
    @Bean
    public WebSocketHandshakeInterceptor handshakeInterceptor() {
        return new WebSocketHandshakeInterceptor();
    }
    @Bean
    public ChatHandshakeInterceptor chatHandshakeInterceptor() {
    	return new ChatHandshakeInterceptor();
    }
}
