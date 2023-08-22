package com.bookingApp.Dto;


import lombok.Data;

@Data
public class UserBookingDto {

    private String UserId;
    private String email;
    private String userUniqueNumber;
    private String bookingUniqueNumber;
    private String bookingItem;

}
