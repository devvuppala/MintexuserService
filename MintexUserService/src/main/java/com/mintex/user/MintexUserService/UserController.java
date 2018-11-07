package com.mintex.user.MintexUserService;

import java.io.Console;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping(value="/hello")
	public String helloMapping() {
		return "Hello ! Welcom to Mintex User Service";
	}
	
	@GetMapping(value="/allusers")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(value="/getuser/{username}")
	public User getAllUsers(@PathVariable("username") String usernameInput) {
		System.out.println(usernameInput);
		return userService.getByUsername(usernameInput); 
	}
	
	@GetMapping(value="/sortingField") 
	public List<User> sortByFirstname(@RequestParam("sorterParameter") String sorter) {
		List<User> users = userService.findAll();
		System.out.println(sorter);
		if(sorter != null && sorter.equalsIgnoreCase("fname")) {
			users.sort(new Comparator<User>() {
				@Override
				public int compare(User o1, User o2) {
					// TODO Auto-generated method stub
					return o1.getFirstname().compareTo(o2.getFirstname());
				}
			});
		} else if(sorter != null && sorter.equalsIgnoreCase("uname")) {
			users.sort(new Comparator<User>() {
				@Override
				public int compare(User o1, User o2) {
					// TODO Auto-generated method stub
					return o1.getUsername().compareTo(o2.getUsername());
				}
			});
		} else {
			users.sort(new Comparator<User>() {
				@Override
				public int compare(User o1, User o2) {
					// TODO Auto-generated method stub
					return o1.getId().compareTo(o2.getId());
				}
			});
		}
		return users;
		
	}
	
	@PostMapping(value = "/addnewuser")
	public User addUser(@RequestBody User newUser) {
		return userService.save(newUser);
	}
	
	
}
