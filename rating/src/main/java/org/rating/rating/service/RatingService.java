package org.rating.rating.service;

import java.util.List;

import org.rating.rating.entity.Rating;

public interface RatingService {
  //create rating
	public Rating createRating(Rating rating);
	//rating by user
	public List<Rating> getRatingByUserId(String userId);
	//all rating
	public List<Rating> getRating();
	//rating by hotel
	public List<Rating> getRatingByHotel(String hotelid);
}
