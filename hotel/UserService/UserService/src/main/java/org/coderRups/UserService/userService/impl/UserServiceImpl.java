package org.coderRups.UserService.userService.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.coderRups.UserService.entity.Hotel;
import org.coderRups.UserService.entity.Rating;
import org.coderRups.UserService.entity.User;
import org.coderRups.UserService.entity.repo.UserRepository;
import org.coderRups.UserService.exception.ResourceNotFoundException;
import org.coderRups.UserService.external.services.HotelService;
import org.coderRups.UserService.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger  logger=LoggerFactory.getLogger(UserServiceImpl.class);
		
	@Override
	public User saveUser(User user) {
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id not found on server !!!"));
/*This used for without rest or feign service
		//	ArrayList<Rating> ratingsbyUser=restTemplate.getForObject("http://localhost:8082/ratings/user/"+userId, ArrayList.class);
		 * 
		 */
			Rating[] ratingsbyUser=restTemplate.getForObject("http://RATING/ratings/user/"+userId, Rating[].class);
       logger.info("{}",ratingsbyUser);
       
  List<Rating> ratingList =   Arrays.stream(ratingsbyUser).toList();
      
     List<Rating> RatingList = ratingList.stream().map(rating->{
    /*
     * commented portion use when using REST Template
    	 //	ResponseEntity<Hotel> forEntity=   restTemplate.getForEntity("http://HOTEL/hotel/"+rating.getHotelId(), Hotel.class);
    	
    	// Hotel hotel=forEntity.getBody();
    	 * 
    	 * 
    	 */
    	 Hotel hotel=hotelService.getHotel(rating.getHotelId());
    	 /*
    	  * Not working this when used feign client
    	//   logger.info("Status code {}",forEntity.getStatusCode());
    	 * 
    	 */
    	   rating.setHotel(hotel);
    	   
    	   return rating;
       }).collect(Collectors.toList());
       
       
    
       
        /*
         * 
         * .collect(Collectors.toList());
       
         *      
         * */
       user.setRating(RatingList);
		return user;
	}

}
