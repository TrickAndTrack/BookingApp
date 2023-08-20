package com.bookingApp.Controller;

import com.bookingApp.Service.UserService;
import com.bookingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User users) {
        return userService.saveUser(users);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/userWithBooking/2")
    public Optional<User> getAllUsersWithBooking(@PathVariable("usersId") Long usersId) {
        return userService.getUserWithBooking(usersId);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User users) {
        return userService.updateUserById(id, users);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }


}
