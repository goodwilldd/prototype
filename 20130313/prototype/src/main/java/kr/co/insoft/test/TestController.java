package kr.co.insoft.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping(value = "/in/test")
	public String test(Model model) {
		return "tiles/home";
	}
}
