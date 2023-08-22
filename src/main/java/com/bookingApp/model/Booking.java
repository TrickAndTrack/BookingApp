package com.bookingApp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookingItem;
    private String bookingUniqueNumber;
    @NotEmpty(message = "User Unique Id may not be empty")
    private String userUniqueNumber;
    private String quantity;
    private double prize;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User users;


}
