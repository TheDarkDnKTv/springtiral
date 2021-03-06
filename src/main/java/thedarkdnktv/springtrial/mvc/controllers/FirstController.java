package thedarkdnktv.springtrial.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String helloPage(HttpServletRequest request, Model model) {
		model.addAttribute("message", String.format("Hello, %s %s!", request.getParameter("name"), request.getParameter("surname")));
		
		return "first/hello";
	}
	
	@GetMapping("goodbye")
	public String goodByePage(@RequestParam(value = "name", required = false) String name,  // Response as Bad request in case of no params.
			@RequestParam String surname) { 												// But set required could not throw anything
		System.out.printf("Bye, %s %s!\n", name, surname);									// In case of surname, can be used without value/name, it just takes arg name
		
		return "first/goodbye";
	}
	
	@GetMapping("calculator")
	public String calculator(@RequestParam int a, @RequestParam int b,
			@RequestParam String action, Model model) {
		double result;
		
		switch (action) {
		case "multiplication":
			result = a * b;
			break;
		case "addition":
			result = a + b;
			break;
		case "substraction":
			result = a - b;
			break;
		case "division":
			result = a / (double) b;
			break;
		default:
			result = Double.NaN;
		}
		
		model.addAttribute("result", result);
		return "first/calculator";
	}
}
