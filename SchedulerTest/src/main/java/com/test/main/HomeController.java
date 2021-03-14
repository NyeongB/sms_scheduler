package com.test.main;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		String s = memberService.sel("1");
		System.out.println(s);
		model.addAttribute("str", s);
		
		//int test_num = memberService.getCoins_test();
		//model.addAttribute("test_num", test_num);
		
		return "home";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Locale locale, Model model)
	{
		
		ArrayList<UserDTO> list = memberService.getUsers();
		//System.out.println(list.get(0).getName());
		for(UserDTO user : list)
		{
			int num = Integer.parseInt(user.getTotal());
			System.out.println(num);
			user.setTotal(String.format("%,d", num));
			user.setCount(""+(num/20));
		}
		model.addAttribute("list", list);
		
		return "user";
	}

}
