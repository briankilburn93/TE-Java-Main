package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// This contains the methods for our API
//
// A Controller is a set of methods for an API stored on a server
//
// This will handle API calls for Hotel data
//
// Essentially all a Controller does is find data and send it back to the API
//
// MVC is a design pattern (a way of coding and structuring applications)
//
// MVC stands for:
//                 Model - the data for application
//                 View  - the interactions with the user
//                 Controller - coordinates the view and data
//                              the View tells the Controller the data what it wants
//                              the Controller get the data from the Model and returns it to the View
//                                       usually as a List of objects or a single object
//
// In this application: View - The services class
//                      Model - The DAOs
//                      Controller - This code that associates paths to methods
//
@RestController  // Tells the server there a methods in here to handle REST API Calls
public class HotelController {   
// Define - Create a name for a piece of memory
// Instantiate - Reserve memory for an object - new classname
// Initialize - Assign a value to an object - constructors
	
    private HotelDAO hotelDAO;             // Define a reference to the HotelDAO
    private ReservationDAO reservationDAO; // Define a reference to the ReservationDAO

    public HotelController() {   // Constructor for the Controller Class - initialize data for this class
        this.hotelDAO = new MemoryHotelDAO();     // Instantiate the HotelDAO and assign it to the reference
        this.reservationDAO = new MemoryReservationDAO(hotelDAO); // Instantiate the ReservationDAO and assign it to the reference
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // @RequestMapping assigns a API path to a method and HTTP request
    //    server-name  :port/path
    //   http://localhost:8080/hotels will cause this method to run
    @RequestMapping(path = "", method = RequestMethod.GET) // handle GET for path /hotels
    public List<Hotel> list() {
    	// This controller method does is get a list of Hotels from the DAO and return it to API caller
    	System.out.println("Hello from the method that handled your /hotels path");
        return hotelDAO.list();  // Call the DAO method to produce a list of Hotels and return it API caller
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    // This method will handle the path /hotels/id  - for example /hotel/1
    // {id} is a path variable - a value passed in the URL path
    // @PathVariable give us access to the path variable in the URL
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {  // Get the path variable from the URL and as an int and call it id
        return hotelDAO.get(id);              // Use the value from the path variable to call the get method 
                                              //               in the hotelDAO and return it
    }

    // Write a Controller to return all the reservations when the path /reservations is used with GET request
    @RequestMapping(path="/reservations", method=RequestMethod.GET) 
    public List<Reservation> listReservations() {
    	return reservationDAO.findAll();  // Call the findAll() in reservation DAO and return to API caller
    }

    // Write a controller to add a reservation to our reservation resource
    //     using the path /hotels/hotel-id/reservations
    //
    //         http://localhost:8080/hotels/1/reservations - will add a reservation to hotel id 1
    //
    // Since we are adding to a resource a POST request will be done by API caller
    //
    // The data for the reservation will be in the body of the API POST request
    //
    // We will return the Reservation we added to the Reservation resource
    //
    // @PathVariable will give us access to the hotel id
    // @RequestBody will give us access to data in the request body - create an object from the data
    //
    //   @RequestBody class-name object-name - convert the JSON in the request body to an object of the class
    //
    @RequestMapping(path="/{id}/reservations",method=RequestMethod.POST)
    public Reservation addReservation(@PathVariable int id, @RequestBody Reservation aReservation) {
    	// We have the hotel id in the int variable called id
    	// We have the reservation information in the Reservation object called silence
    	
    	// Call the Reservation DAO method to add the the reservation to the resource
    	reservationDAO.create(aReservation, id);
    	
    	return aReservation;
    }
    // Write a controller to return all reservations for a given hotel
    //
    // Handle the path /hotels/id/reservations for a GET request
 
    @RequestMapping(path="/{id}/reservations",method=RequestMethod.GET)
    public List<Reservation> getAReservation(@PathVariable int id) {
    	return reservationDAO.findByHotel(id);
    }
    
    /**
     * /hotels/filter?state=oh&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path ="/hotels/filter", method=RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(required = false) String city) {

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
