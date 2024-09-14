package org.rating.rating.repo;

import java.util.List;

import org.rating.rating.entity.Rating;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {

	List<Rating> findByHotelId(String hotelId);
	List<Rating> findByUserId(String userId);
}
