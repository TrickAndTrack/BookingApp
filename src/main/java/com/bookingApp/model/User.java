package com.bookingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String userUniqueNumber;
//@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    //  @OneToMany(mappedBy = "users")
//    @JoinColumn(name="ub_fk", referencedColumnName = "id")
//    private List<Booking> bookings = new ArrayList<>();



}
