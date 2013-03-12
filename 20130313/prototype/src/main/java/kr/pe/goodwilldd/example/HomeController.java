package kr.pe.goodwilldd.example;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.pe.goodwilldd.core.exception.GenericException;
import kr.pe.goodwilldd.core.util.UtilFactory;
import kr.pe.goodwilldd.example.model.ExampleModel;
import kr.pe.goodwilldd.example.model.User;
import kr.pe.goodwilldd.example.service.ExampleServiceIF;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private UtilFactory utilFactory;

	@Autowired
	ExampleServiceIF exampleService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info(exampleService.getUserName("svary"));

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		// model.addAttribute("serverTime", formattedDate);
		model.addAttribute("example", new ExampleModel(1, "goodwilldd hello!"));

		return "tiles/home";
	}

	@RequestMapping("/exp")
	public void testException(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		throw new GenericException("GenericException Test!!!!!");
	}

	@RequestMapping("/exp2")
	public void test2Exception(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int res = 1 / 0;
	}

	/**
	 * json 이나 xml로 값을 반환하기 위해서는 반드시 ResponseBody Annotation을 선언하고 변환하여 반환할 대상
	 * 객체에 XmlRootElement, JsonAutoDetect Annotation을 선언하여야 한다.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/test")
	@ResponseBody
	public ExampleModel doTest() {
		return new ExampleModel(1, "goodwilldd hello!");
	}

	/**
	 * Plain JSP
	 */
	@RequestMapping(value = "/phome", method = RequestMethod.GET)
	public String findUsersPlain(Model model) {
		buildUserList(model);
		model.addAttribute("title", "Users List - Plain JSP");
		return "/home";
	}

	/**
	 * JSP with Tiles
	 */
	@RequestMapping(value = "/tiles3", method = RequestMethod.GET)
	public String findUsersTiles(Model model) {
		buildUserList(model);
		model.addAttribute("title", "Users List - Tiles");
		model.addAttribute("nownow", utilFactory.getDateUtil().now());
		exampleService.getUserName("svary");
		return "tiles/users";
	}

	/**
	 * JSP with ThymeLeaf
	 */
	@RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
	public String findUsersThymeLeaf(Model model) {
		buildUserList(model);
		model.addAttribute("title", "Users List - Thymeleaf");
		return "thymeleaf/users";
	}

	@RequestMapping(value = "/chatView", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("title", "Chating!!");
		return "thymeleaf/chat";
	}

	private void buildUserList(Model model) {
		List<User> users = new ArrayList<User>();
		users.add(new User("Paul", "Chapman"));
		users.add(new User("Mike", "Wiesner"));
		users.add(new User("Mark", "Secrist"));
		users.add(new User("Ken", "Krueger"));
		users.add(new User("Wes", "Gruver"));
		users.add(new User("Kevin", "Crocker"));
		model.addAttribute("users", users);
	}
}
