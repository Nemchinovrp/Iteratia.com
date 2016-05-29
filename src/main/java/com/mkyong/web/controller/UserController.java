package com.mkyong.web.controller;

import com.mkyong.web.repository.UserRepository;
import com.mkyong.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String viewAllUser(ModelMap model) {
		List<User> users = userRepository.getAllUser();
		model.addAttribute("users", users);
		return "listUser";
	}

	@RequestMapping("/addUserForm")
	public String addUserForm(ModelMap model) {
		return "user";
	}

	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute User user) {
		userRepository.createUser(user);
		return "redirect:/User";
	}
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer id) {
		userRepository.deleteUser(id);
		return "redirect:/User";
	}

}