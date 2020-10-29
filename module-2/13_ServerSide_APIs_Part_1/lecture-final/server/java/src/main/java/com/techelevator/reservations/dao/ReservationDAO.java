package com.techelevator.reservations.dao;

import java.util.List;
import com.techelevator.reservations.models.Reservation;

public interface ReservationDAO {

    List<Reservation> findAll();

    List<Reservation> findByHotel(int hotelID);

    Reservation get(int reservationID);
    //  the create method will receive a reservation and hotelID and return a reservations
    Reservation create(Reservation reservation, int hotelID);
}
