package com.bookingApp.Service;

import com.bookingApp.Dto.LatestBooking;
import com.bookingApp.model.Booking;

import java.util.List;

public interface bookingService {

    Booking booking(Booking booking);

    public List<LatestBooking> getAllBookings();
}
