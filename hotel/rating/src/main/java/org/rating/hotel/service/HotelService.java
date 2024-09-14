package org.rating.hotel.service;

import java.util.List;

import org.rating.hotel.entity.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	public List<Hotel> getAllHotel();
	public Hotel getHotelByID(String id);

}
