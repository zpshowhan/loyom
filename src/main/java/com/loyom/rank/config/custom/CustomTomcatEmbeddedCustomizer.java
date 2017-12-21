//package com.loyom.rank.config.custom;
//
//import java.io.File;
//
//import org.apache.catalina.connector.Connector;
//import org.apache.coyote.http11.Http11NioProtocol;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 
//* @ClassName: CustomTomcatEmbeddedCustomizer 
//* @Description: TODO 编程方式自定义内嵌容器tomcat 
//* @Company:esmart
//* @author Thinkpad 
//* @version 1.0 2017年12月21日 上午10:58:15
// */
//
//@Configuration
//@ConfigurationProperties(prefix = "tomcat")
//public class CustomTomcatEmbeddedCustomizer {
//	
//	/**
//	* 订制内嵌tomcat容器
//	*/
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		
//		//通过addAdditionalTomcatConnectors方法添加多个监听连接;
//		//此时可以通过http 9090端口，https 8443端口
////		factory.addAdditionalTomcatConnectors(createSslConnector());
//		
//		
//		factory.addConnectorCustomizers(new TomcatConnectorCustomizer(){
//
//			@Override
//			public void customize(Connector connector) {
//				// TODO Auto-generated method stub
//				Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//				//设置最大连接数  
//		        protocol.setMaxConnections(2000);  
//		        //设置最大线程数  
//		        protocol.setMaxThreads(2000);  
//		        protocol.setConnectionTimeout(30000);
//		        //使用protocol去配置SSL https请求方式
////		        connector.setScheme("https");
////	            protocol.setSSLEnabled(true);
//		        //监听端口
//		        connector.setPort(9090);
//		        connector.setPort(9091);
//				connector.setURIEncoding("UTF-8");
//			}
//			
//		});
////		factory.setPort(9090);
//		return factory;
//	}
//	
//	private Connector createSslConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//        try {
//            File truststore = new File("/Users/liaokailin/software/ca1/keystore");
//            connector.setScheme("https");
//            protocol.setSSLEnabled(true);
//            connector.setSecure(true);
//            connector.setPort(8443);
//            protocol.setKeystoreFile(truststore.getAbsolutePath());
//            protocol.setKeystorePass("123456");
//            protocol.setKeyAlias("springboot");
//            return connector;
//        } catch (Exception ex) {
//            throw new IllegalStateException("cant access keystore: [" + "keystore" + "]  ", ex);
//        }
//    }
//}
