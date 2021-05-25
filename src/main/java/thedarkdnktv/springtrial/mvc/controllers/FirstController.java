package thedarkdnktv.springtrial.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author TheDarkDnKTv
 *
 */
@Controller
@RequestMapping("first")
public class FirstController {
	
	@GetMapping("hello")
	public String helloPage(HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		System.out.printf("Hello, %s %s!\n", name, surname);
		
		return "first/hello";
	}
	
	@GetMapping("goodbye")
	public String goodByePage(@RequestParam(value = "name", required = false) String name,  // Response as Bad request in case of no params.
			@RequestParam String surname) { 												// But set required could not throw anything
		System.out.printf("Bye, %s %s!\n", name, surname);									// In case of surname, can be used without value/name, it just takes arg name
		
		return "first/goodbye";
	}
}
