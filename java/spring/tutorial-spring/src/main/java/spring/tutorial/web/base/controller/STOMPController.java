package spring.tutorial.web.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.tutorial.web.base.vo.MessageVO;
import spring.tutorial.web.base.vo.ResponseMessageVO;

import java.security.Principal;

@Controller
public class STOMPController {

    @Autowired
    private SimpMessageSendingOperations messaging;

    /**
     * send message to client
     * `@sendTo`：any alient which subscribe this theme will receive response
     *
     * @param messageVO
     * @return
     */
    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public ResponseMessageVO handlerHello(MessageVO messageVO) {
        String message = String.format("hello client! I have received message:%s", messageVO.getMessage());
        System.out.println(message);
        ResponseMessageVO responseMessageVO = new ResponseMessageVO();
        responseMessageVO.setResponseMessage(message);
        return responseMessageVO;
    }

    /**
     *  应用场景为：请求-响应模式
     *  客户端订阅某一个目的地，然后预期在这个目的地上获得一个一次性的响应(异步)
     *
     * @return
     */
    @SubscribeMapping("/subscribe/hello")
    public ResponseMessageVO handlerSubscribe(Principal principal) {
        String message = String.format("welcome！you have subscribe me。you are %s", principal.getName());
        ResponseMessageVO responseMessageVO = new ResponseMessageVO();
        responseMessageVO.setResponseMessage(message);
        return responseMessageVO;
    }

    @RequestMapping("/")
    public void broadcastMessage(MessageVO messageVO) {
        String message = String.format("hello %s, I an sending message to you", messageVO.getMessage());
        System.out.println(message);
        ResponseMessageVO responseMessageVO = new ResponseMessageVO();
        responseMessageVO.setResponseMessage(message);
        messaging.convertAndSend("/topic/broadcast", responseMessageVO);
    }
}
