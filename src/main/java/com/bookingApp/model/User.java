package com.bookingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {

    // we need to add serializable

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
