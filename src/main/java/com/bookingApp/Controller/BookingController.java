package com.bookingApp.Controller;

import com.bookingApp.Dto.LatestBooking;
import com.bookingApp.Service.bookingService;
import com.bookingApp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private bookingService bookingService;

    // http://localhost:8080/api/v1
    @PostMapping("/saveBooking")
    public Booking saveBooking(@RequestBody Booking booking) {
        return  bookingService.booking(booking);
    }

    @GetMapping("/bookingList")
    public List<LatestBooking> getlatestUsers() {
        return bookingService.getAllBookings();
    }

}
