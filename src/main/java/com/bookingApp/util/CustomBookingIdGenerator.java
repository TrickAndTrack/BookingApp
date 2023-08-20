package com.bookingApp.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomBookingIdGenerator implements IdentifierGenerator {

    public static final String VALUE_PREFIX_PARAMETER="booking";


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {

        // Random random = new Random();
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDate = currentDate.format(formatter);
        return VALUE_PREFIX_PARAMETER+formattedDate;
    }


}
