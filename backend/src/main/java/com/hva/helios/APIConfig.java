package com.hva.helios;

import com.hva.helios.notifications.AnnouncementDistributor;
import com.hva.helios.notifications.NotificationDistributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

@Component
@EnableWebSocket
public class APIConfig implements WebMvcConfigurer, WebSocketConfigurer {

    //TODO: add protected endpoints here after frontend is done
    public static final List<String> SECURED_PATHS = List.of();
    @Value("florijn")
    String issuer;

    @Value("thepowerofanimealwayswinsuwumaajiddennissimoniliaswerkenvoorflorijn.nlisnietaltijdfijn.nllolhaha")
    String passphrase;

    @Value("1200")
    int TokenDurationOfValidity;

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
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .exposedHeaders("*")
                .allowCredentials(true);
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

    public String getIssuer() {
        return issuer;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public int getTokenDurationOfValidity() {
        return TokenDurationOfValidity;
    }
}
