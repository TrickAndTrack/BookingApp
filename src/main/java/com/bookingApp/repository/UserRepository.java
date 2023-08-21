package com.bookingApp.repository;

import com.bookingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

  //  @Query(value ="select u.userName, u.email, b.bookingItem, b.price from User u left join u.bookings b",nativeQuery=true)
   // List<User> findAllWithBooking();

  //  @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.booking b WHERE u.userId = :user_id")
 //   Optional<User> findUserWithBooking(@Param("user_id") Long userId);

    List<User> findByName(String name);
}
