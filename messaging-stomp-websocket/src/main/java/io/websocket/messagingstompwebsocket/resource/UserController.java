 package io.websocket.messagingstompwebsocket.resource;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import io.websocket.messagingstompwebsocket.model.User;
import io.websocket.messagingstompwebsocket.model.UserResponse;

@Controller
public class UserController {

	@MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) {
        return new UserResponse("Hi " + user.getName());
    }

}
