package com.bookingApp.Service;

import com.bookingApp.Dto.UserBookingDto;
import com.bookingApp.model.User;

import java.util.List;

public interface UserService {

   // Optional<User> getUserWithBooking(Long usersId);

    User saveUser(User users);

    List<User> fetchAllUsers();

    User getUserById(Long id);

    User updateUserById(Long id, User users);

    String deleteUserById(Long id);
//    List<UserBookingDto> getAllUsersBooking();


    public List<UserBookingDto> getAllUsers();
}
