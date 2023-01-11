package com.hva.helios.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles WebSocket connections and broadcasts messages to all connected clients.
 * @author Simon Vriesema
 */
@Component
public class AnnouncementDistributor extends TextWebSocketHandler {
    // Declare a logger instance to log messages
    private static final Logger logger = LoggerFactory.getLogger(AnnouncementDistributor.class);
    // Declare a list to store active WebSocket sessions
    private final List<WebSocketSession> sessions = new ArrayList<>();

    /**
     * Handles incoming messages and broadcasts them to all connected clients.
     *
     * @param session the WebSocket session that the message was received from
     * @param message the received message
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Log the number of active sessions
        logger.info("Number of active sessions: {}", this.sessions.size());
        // Iterate through the list of sessions and send the message to each session
        for (WebSocketSession webSocketSession : sessions) {
            try {
                // Log the session id that the message is being sent to
                logger.info("Sending message to " + webSocketSession.getId());
                // Send the message to the session
                webSocketSession.sendMessage(new TextMessage(message.getPayload()));
            } catch (IOException e) {
                // If there is an error sending the message, remove the session from the list and log the error
                logger.info("Communication with session with id " + session.getId() + " failed - removing it from the list");
                sessions.remove(webSocketSession);
            }
        }
    }

    /**
     * Adds a newly established WebSocket session to the list of active sessions.
     *
     * @param session the newly established WebSocket session
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // Add the session to the list of active sessions
        sessions.add(session);
        // Log the session id that was added
        logger.info("Session {} was added", session.getId());
    }

    /**
     * Removes a closed WebSocket session from the list of active sessions.
     *
     * @param session the closed WebSocket session
     * @param status  the close status
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // Remove the session from the list of active sessions
        sessions.remove(session);
        // Log the session id that was removed
        logger.info("Session {} was removed", session.getId());
    }
}
