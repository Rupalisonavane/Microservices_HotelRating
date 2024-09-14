package org.rating.hotel.controller;

import java.util.List;

import org.rating.hotel.entity.Hotel;
import org.rating.hotel.service.HotelService;
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
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/")
	public ResponseEntity<Hotel> createsHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.createHotel(hotel));
	}
	
	@GetMapping("/")
	public ResponseEntity< List<Hotel>> getAllHotel()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel()) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelByID(id));
	}
	
}
