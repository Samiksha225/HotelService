package com.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;


@Service
public class HotelServiceImpl implements HotelService{
	
	
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> hotelList() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(int id) {
		return hotelRepo.findById(id).orElseThrow();
	}

}
