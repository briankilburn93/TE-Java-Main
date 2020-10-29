package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.exception.ReservationNotFoundException;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO hotelDAO;							// Define a reference to HotelDAO
    private ReservationDAO reservationDAO;				// Define a reference to ReservationDAO

    // The ctr assigns objects to the HotelDAO and ReservationDAO references using params passed to it
    
    // Where do the objects for the params come from?
    //		Normally the params are passed when the class is instantiated
    //		We are using Spring Dependency Injection to instantiate DAO objects
    //			and pass them to this ctr
    // Spring MVC instantiates the controller for us <------------
    
    // The DAOs require the @Component annotation to tell Spring they should
    //		
    
    public HotelController(HotelDAO hotelDAO, ReservationDAO reservationDAO) {
        this.hotelDAO = hotelDAO;						// Assign the parameter passed
        this.reservationDAO = reservationDAO;			// Assign the parameter passed
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDAO.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) throws ReservationNotFoundException {
        return reservationDAO.get(id);
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelID
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelID) throws HotelNotFoundException {
        return reservationDAO.findByHotel(hotelID);
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     * @param hotelID
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.POST)
    // @Valid tells Spring to use the validation annotation in the class when assigning data to the object
    public Reservation addReservation(@Valid @RequestBody Reservation reservation, @PathVariable("id") int hotelID)
            throws HotelNotFoundException {
        return reservationDAO.create(reservation, hotelID);
    }

    /**
     * /hotels/filter?state=oh&city=cleveland
     *
     *@RequestParam - access the data in the query string
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    // This method will handle the path /hotels/filter
    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(required = false) String city) {
//			@RequestParam(value="district", defaultValue="Ohio") String state
//				- if you want to change value to district instead of state, default state will be Ohio
//					So, http://localhost:8080/hotels/filter?district=utah - will get you Utah
//					and, http://localhost:8080/hotels/filter - will get you Ohio because defaultValue
    	
    // @RequestParam - go get the variable listed from the query string (what follows in ? in the 
    	//			get the value in the state from the query string
    	//			and store it in the variable state in the method
    	//				required = false - the parameter may be missing (it's not required)
        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> hotels = list();

        // return hotels that match state
        for (Hotel hotel : hotels) {

            // if city was passed we don't care about the state filter
            if (city != null) {
                if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())) {
                    filteredHotels.add(hotel);
                }
            } else {
                if (hotel.getAddress().getState().toLowerCase().equals(state.toLowerCase())) {
                    filteredHotels.add(hotel);
                }

            }
        }

        return filteredHotels;
    }

}
