package com.bookingApp.Controller;

import com.bookingApp.Service.UserService;
import com.bookingApp.model.User;
import com.bookingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;



    // http://localhost:8080/api/v2
    @PostMapping
    public User saveUser(@RequestBody User users) {
        return userService.saveUser(users);
    }

   // http://localhost:8080/api/v2/users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }


    // http://localhost:8080/api/v2/users/name=name?mlvb
    @GetMapping("/users/name")
    public ResponseEntity<List<User>> getUsersByName(@RequestParam String name) {
        return new ResponseEntity<List<User>>(userRepository.findByName(name), HttpStatus.OK);
    }

    // http://localhost:8080/api/v2/1

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    // http://localhost:8080/api/v2/1
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User users) {
        return userService.updateUserById(id, users);
    }

    // http://localhost:8080/api/v2/1
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }

//http://localhost:8080/api/v2/user-booking

//    @GetMapping("/user-booking")
//    private List<UserBookingDto> getAllUserWithBooking(){
//        return userService.getAllUsersBooking();
//    }


}
