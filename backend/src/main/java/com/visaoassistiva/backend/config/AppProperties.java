package com.visaoassistiva.backend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class AppProperties {

    private Ia ia = new Ia();
    private Cors cors = new Cors();
    private RateLimit rateLimit = new RateLimit();
    private Persistencia persistencia = new Persistencia();
    private Filtro filtro = new Filtro();
    private Websocket websocket = new Websocket();

    @Getter
    @Setter
    public static class Cors {
        private List<String> allowedOrigins = List.of("http://localhost:5173");
    }

    @Getter
    @Setter
    public static class Ia {
        private String baseUrl = "http://ia-service:8000";
        private int timeoutConnectMs = 2000;
        private int timeoutReadMs = 5000;
    }

    @Getter
    @Setter
    public static class RateLimit {
        private int fps = 5;
    }

    @Getter
    @Setter
    public static class Persistencia {
        private boolean habilitada = true;
    }

    @Getter
    @Setter
    public static class Filtro {
        private List<String> classesRelevantes = new ArrayList<>();
    }

    @Getter
    @Setter
    public static class Websocket {
        private int maxTextMessageSizeBytes = 10_485_760;
        private int maxBinaryMessageSizeBytes = 10_485_760;
    }
}
