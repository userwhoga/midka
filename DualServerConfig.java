package com.example.demo;


import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DualServerConfig {

    @Bean
    public WebServerFactory mvcServer() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.setPort(8080); // Tomcat запускается на порту 8080
        return tomcatFactory;
    }

    @Bean
    public WebServerFactory webfluxServer() {
        NettyReactiveWebServerFactory nettyFactory = new NettyReactiveWebServerFactory();
        nettyFactory.setPort(8081); // Netty запускается на порту 8081
        return nettyFactory;
    }
}
