package org.coderRups.UserService.userService;

import java.util.List;

import org.coderRups.UserService.entity.User;

public interface UserService {

	 User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
}
