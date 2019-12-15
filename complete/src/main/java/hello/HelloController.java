package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String index() throws InterruptedException{
		Thread.sleep((int)(Math.random() * ((150 - 100) + 1)) + 100);
		return "Greetings from Spring Boot!";
	}
	
}
