package org.coderRups.UserService.external.services;

import org.coderRups.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL")
public interface HotelService {

	@GetMapping("hotel/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId") String hotelId);
}
