package com.bookingApp.repository;

import com.bookingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

  //  @Query(value ="select u.userName, u.email, b.bookingItem, b.price from User u left join u.bookings b",nativeQuery=true)
   // List<User> findAllWithBooking();

    @Query(value="SELECT u FROM User u LEFT JOIN FETCH u.bookings b WHERE u.userId = :user_id",nativeQuery=true)
    Optional<User> findUserWithBooking(@Param("user_id") Long usersId);



}
