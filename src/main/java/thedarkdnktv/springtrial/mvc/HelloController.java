package thedarkdnktv.springtrial.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author TheDarkDnKTv
 *
 */
@Controller
public class HelloController {

	@GetMapping("hello-world")
	public String sayHello() {
		return "hello_world";
	}
}
