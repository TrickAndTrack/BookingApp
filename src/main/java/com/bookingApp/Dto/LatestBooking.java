package com.bookingApp.Dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatestBooking {

    private String name;
    private String bookingItem;
    private String bookingUniqueNumber;
    private String userUniqueNumber;
}
