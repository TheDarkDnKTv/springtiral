package thedarkdnktv.springtrial.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author TheDarkDnKTv
 *
 */
@Controller
public class SecondController {
	
	@GetMapping("exit")
	public String exit() {
		return "second/exit";
	}
}
