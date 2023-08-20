package com.bookingApp.Service.impl;

import com.bookingApp.Service.bookingService;
import com.bookingApp.model.Booking;
import com.bookingApp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class BookingServiceImpl implements bookingService {

    public static final String VALUE_PREFIX_PARAMETER="booking";

    @Autowired
    public BookingRepository bookingRepository;


    @Override
    public Booking booking(Booking booking) {
        booking.setBookingUniqueNumber(bookingUniqueIdGenerator());
        return bookingRepository.save(booking);
    }

    public String bookingUniqueIdGenerator (){
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDate = currentDate.format(formatter);
        return VALUE_PREFIX_PARAMETER+formattedDate;
    }

}
