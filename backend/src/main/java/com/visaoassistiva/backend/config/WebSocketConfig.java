package com.visaoassistiva.backend.config;

import com.visaoassistiva.backend.websocket.ImagemWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ImagemWebSocketHandler imagemWebSocketHandler;
    private final AppProperties appProperties;

    public WebSocketConfig(ImagemWebSocketHandler imagemWebSocketHandler,
                           AppProperties appProperties) {
        this.imagemWebSocketHandler = imagemWebSocketHandler;
        this.appProperties = appProperties;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        String[] origins = appProperties.getCors().getAllowedOrigins().toArray(new String[0]);
        registry.addHandler(imagemWebSocketHandler, "/ws")
                .setAllowedOrigins(origins);
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(appProperties.getWebsocket().getMaxTextMessageSizeBytes());
        container.setMaxBinaryMessageBufferSize(appProperties.getWebsocket().getMaxBinaryMessageSizeBytes());
        return container;
    }
}
