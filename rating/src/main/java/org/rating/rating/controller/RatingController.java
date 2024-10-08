package org.rating.rating.controller;

import java.util.List;

import org.rating.rating.entity.Rating;
import org.rating.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@GetMapping("/")
	public ResponseEntity<List<Rating>> getRating()
	{
		return ResponseEntity.ok(ratingService.getRating());
	}
	
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity< List<Rating>> getRatingByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(ratingService.getRatingByHotel(hotelId));
	}
	
}
