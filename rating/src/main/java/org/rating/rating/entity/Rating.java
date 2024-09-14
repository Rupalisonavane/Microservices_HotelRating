package org.rating.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("users_rating")
public class Rating {
	@Id
	private String  ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
