package com.hva.helios;

import com.hva.helios.notifications.AnnouncementDistributor;
import com.hva.helios.notifications.NotificationDistributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Component
@EnableWebSocket
public class APIConfig implements WebMvcConfigurer, WebSocketConfigurer {
    @Autowired
    private AnnouncementDistributor announcementDistributor;

    @Autowired
    private NotificationDistributor notificationDistributor;

    @Value("${allowed.cors.clients:http://*.hva.nl:*}")
    private String allowedCorsClients;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    private String getHostIPAddressPattern() {
        try {
            return "http://" + Inet4Address.getLocalHost().getHostAddress() + ":*";
        } catch (UnknownHostException ignored) {
        }
        return "http://192.168.*.*:*";
    }


    /**
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.announcementDistributor, "/announcements")
                .setAllowedOriginPatterns("http://localhost:*", getHostIPAddressPattern(), allowedCorsClients)
        //.withSockJS()
        ;
        registry.addHandler(this.notificationDistributor, "/notifications")
                .setAllowedOriginPatterns("http://localhost:*", getHostIPAddressPattern(), allowedCorsClients)
        //.withSockJS()
        ;
    }
}
