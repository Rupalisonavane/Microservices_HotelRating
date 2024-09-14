package org.rating.rating.service.impl;

import java.util.List;

import org.rating.rating.entity.Rating;
import org.rating.rating.exception.ResourceNotFoundException;
import org.rating.rating.repo.RatingRepository;
import org.rating.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	@Override
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByHotel(String hotelid) {
		return ratingRepository.findByHotelId(hotelid);
	}

}
