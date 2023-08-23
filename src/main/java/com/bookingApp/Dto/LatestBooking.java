package com.bookingApp.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatestBooking {

    private String bookingItem;
    private String bookingUniqueNumber;
    private String userUniqueNumber;
}
