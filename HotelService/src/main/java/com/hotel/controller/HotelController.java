package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entities.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}

	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> hotelList() {
		List<Hotel> hotel = hotelService.hotelList();
		return ResponseEntity.ok(hotel);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable int hotelId) {
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}

}
