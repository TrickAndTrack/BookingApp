package com.bookingApp.Service.impl;

import com.bookingApp.Dto.LatestBooking;
import com.bookingApp.Service.bookingService;
import com.bookingApp.model.Booking;
import com.bookingApp.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookingServiceImpl implements bookingService {

    public static final String VALUE_PREFIX_PARAMETER="booking";

    @Autowired
    public BookingRepository bookingRepository;

    @Autowired(required=true)
    private ModelMapper modelMapper;


    @Override
    public Booking booking(Booking booking) {
        booking.setBookingUniqueNumber(bookingUniqueIdGenerator());

        return bookingRepository.save(booking);
    }

    @Override
    public List<LatestBooking> getAllBookings() {
        List<Booking> listBooking = bookingRepository.findAll();
        return listBooking.stream()
                .map(Booking -> modelMapper.map(Booking, LatestBooking.class))
                .collect(Collectors.toList());
    }

    public String bookingUniqueIdGenerator (){
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDate = currentDate.format(formatter);
        return VALUE_PREFIX_PARAMETER+formattedDate;
    }

}
