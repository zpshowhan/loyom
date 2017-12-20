package com.loyom.rank.config.interceptor;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;


public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

	public static Logger log = Logger.getLogger(WebSocketHandshakeInterceptor.class.toString());
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Exception exp) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
			Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		// 此处可以做一些权限认证的事情或者其他
		log.info(map.toString());
		log.info(request.getHeaders().toString());
        return true;
	}

}
