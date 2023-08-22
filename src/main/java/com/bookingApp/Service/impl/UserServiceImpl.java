package com.bookingApp.Service.impl;

import com.bookingApp.Dto.UserBookingDto;
import com.bookingApp.Service.UserService;
import com.bookingApp.model.User;
import com.bookingApp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final String VALUE_PREFIX_PARAMETER="booking";
    @Autowired
    public UserRepository userRepository;

    @Autowired(required = true)
    private ModelMapper modelMapper;

    @Override
    public User saveUser(User users) {
            users.setUserUniqueNumber(userUniqueIdGenerator());
            return userRepository.save(users);
    }


    @Override
    public List<User> fetchAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> users = userRepository.findById(id);
        if (users.isPresent()) {
            return users.get();
        }
        return null;
    }



    @Override
    public User updateUserById(Long id, User users) {
        Optional<User> users1 = userRepository.findById(id);

        if (users1.isPresent()) {
             User originalUsers = users1.get();

            if (Objects.nonNull(users.getName()) && !"".equalsIgnoreCase(users.getName())) {
                originalUsers.setName(users.getName());
            }
            if (Objects.nonNull(users.getEmail()) && !"".equalsIgnoreCase(users.getEmail())) {
                originalUsers.setEmail(users.getEmail());
            }
            return userRepository.save(originalUsers);
        }
        return null;
    }

    @Override
       public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such User in the database";
    }
    public String userUniqueIdGenerator (){
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDate = currentDate.format(formatter);
        return VALUE_PREFIX_PARAMETER+formattedDate;
    }

//    @Override
//    public List<UserBookingDto> getAllUsersBooking(){
//        return userRepository.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());

//    }






}

