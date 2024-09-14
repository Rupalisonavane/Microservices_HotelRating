package org.rating.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.rating.hotel.ResourceNotFoundException;
import org.rating.hotel.entity.Hotel;
import org.rating.hotel.repo.HotelRepository;
import org.rating.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelid=UUID.randomUUID().toString();
		hotel.setId(hotelid);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelByID(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given Id Not Found!!!"));
	}



}
