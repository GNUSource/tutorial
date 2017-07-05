package spring.tutorial.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MarcoHandler extends AbstractWebSocketHandler {


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println("received message：" + message.getPayload());

        Thread.sleep(2000);

        session.sendMessage(new TextMessage("Polo!"));
    }
}
