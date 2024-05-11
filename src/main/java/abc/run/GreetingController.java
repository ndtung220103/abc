package abc.run;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

//@CrossOrigin(origins = "http://127.0.0.1:5500/")
@Controller
public class GreetingController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/chat")
	public String message(@Payload Message message) throws Exception {
		System.out.println(message.getFrom());
	   // return new Message(message.getFrom(), message.getText());
		return "hello";
	}
}
