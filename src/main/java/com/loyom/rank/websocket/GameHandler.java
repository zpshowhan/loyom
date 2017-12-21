package com.loyom.rank.websocket;

import java.net.URI;
import java.util.logging.Logger;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


public class GameHandler extends AbstractWebSocketHandler {

	public static Logger log = Logger.getLogger(GameHandler.class.toString());
	/**
     * 处理字符串类的信息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        session.sendMessage(new TextMessage(message.getPayload()));
        log.info("处理字符串类的信息");
        log.info(session.getId());
        log.info(message.getPayload());
    }

    /**
     * 处理二进制类的信息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        session.sendMessage(new BinaryMessage(message.getPayload()));
        log.info("处理二进制类的信息");
        log.info(session.getId());
        log.info(message.getPayload().toString());
    }

    /**
     * ping-pong
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
	
    	log.info("ping-pong");
        log.info(session.getId());
        log.info(message.toString());
    }

    /**
     * 传出错误的处理
     *
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
	
	if(session.isOpen()){
    	    session.close();
    	}
    	log.info("传出错误的处理");
        log.info(session.getId());
        log.info(exception.getMessage());
        
    }

    /**
     * 连接关闭的处理
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    	
	if(session.isOpen()){
    		session.close(status);
    	}
    	log.info("连接关闭的处理");
        log.info(session.getId());
        log.info(status.getReason());
    }

    /**
     * 连接建立后的处理
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	
    	log.info("连接建立后的处理");
        log.info(session.getId());
    }
}
