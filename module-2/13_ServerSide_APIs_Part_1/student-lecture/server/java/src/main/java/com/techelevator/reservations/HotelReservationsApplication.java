package com.techelevator.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This is the server for our application

// It's a Spring Boot Server - means it's an easy to implement server from the people that main Spring

@SpringBootApplication
public class HotelReservationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelReservationsApplication.class, args);
    }

}
