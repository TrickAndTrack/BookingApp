package com.bookingApp.exception;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ErrorDetails {

    private String message;

    private LocalDateTime lct;

    private String desc;
}
