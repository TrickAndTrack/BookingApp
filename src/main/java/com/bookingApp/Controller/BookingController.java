package com.bookingApp.Controller;

import com.bookingApp.Service.bookingService;
import com.bookingApp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private bookingService bookingService;

    @PostMapping
    public Booking saveBooking(@RequestBody Booking booking) {
        return  bookingService.booking(booking);
    }

}
