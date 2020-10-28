package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String BASE_URL;         // Define a reference to hold the URL for the API to be called
  private final RestTemplate restTemplate = new RestTemplate(); // Define and instantiate a restTemplate
  private final ConsoleService console    = new ConsoleService();  // Use consoleService to handle user interactions
   
  public HotelService(String url) {   // Receive an API URL from the user
    BASE_URL = url;                   // Assign URL passed from user to the BASE_URL we use in this code
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  
public Reservation addReservation(String newReservation) {
    // To add a Reservation to API - we need to use HTTP POST request
	// When we do a POST we need to put the data in request body \\
	  
	// Create a Reservation object from the String passed into this method
	//          using the helper method makeReservation defined below
	Reservation aReservation = makeReservation(newReservation);
	
	// if always a good practice to be sure you have an object
	if (aReservation == null) {
		console.printError("Invalid data for a Reservation");
		return null;
	}
	// Now that we have a Reservation object we need to send to server via API
	// using an HTTP POST request
	
	// A POST request requires headers to tell the server about the request
	//   and the data for the request has to be in the body of  the request
	
	HttpHeaders theHeader = new HttpHeaders(); // Instantiate an object for request headers
	
	// Tell server we're sending it JSON data in the request body
	theHeader.setContentType(MediaType.APPLICATION_JSON); // MediaType is a group of constants
	                                                      // for datatypes you can send to server
	
	// so we have the object to send to the server and the headers to describe the data
	// all that's left is to combine them into an HTTP Request using HttpEntity class
	//                      put these in request body, request header
	HttpEntity anEntity = new HttpEntity(aReservation, theHeader);
	
	// Call the API with a POST request to add reservation to the server
	// the API will return the Reservation object that was added to the server
	// Use the PostForObject method to issue a POST request with restTemplate
	
	//                                             URL                  request   class for returned object
	aReservation = restTemplate.postForObject(BASE_URL + "reservations", anEntity, Reservation.class);
	
	return aReservation;
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param CSV
   * @return
   */
  public Reservation updateReservation(String CSV) {
    
	  Reservation aReservation = makeReservation(CSV);  // Create a new reservation from the parameter
	  
	  if (aReservation == null) {
		  console.printError("Invalid data for reservation");
		  return null;
	  }
	  HttpHeaders theHeaders = new HttpHeaders();            // Create the headers for the request
	  theHeaders.setContentType(MediaType.APPLICATION_JSON); // Tell the server we are sending JSON
	  
	  HttpEntity anEntity = new HttpEntity(aReservation, theHeaders);  // Put the data and headers together
	  
	  // HTTP PUT does not return and data - so there is nothing to store when it returns
	  //                BASE_URL/reservations/id to be changed       , request
	  restTemplate.put(BASE_URL + "reservations/" + aReservation.getId(), anEntity); // Issue the PUT to update the data on the server
	  
    return aReservation;
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    // Delete does not require and data in the body of the request nor does it return anything
	// All we do is call API with the URL required to identify what you want to delete
	  
	  restTemplate.delete(BASE_URL + "reservations/" + id);
  }

  /* DON'T MODIFY ANY METHODS BELOW */
  /* DON'T MODIFY ANY METHODS BELOW */
  /* DON'T MODIFY ANY METHODS BELOW */

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    try {
      hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) {
      // handles exceptions thrown by rest template and contains status codes
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      // i/o error, ex: the server isn't running
      console.printError(ex.getMessage());
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }
 // Method will create a Reservation object from a comma-delimited
  private Reservation makeReservation(String CSV) {  // receives a String we are CSV
    String[] parsed = CSV.split(",");  // split the String passed as an argument into parts based on ,

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) { // check if 5 or 6 Strings were passed in
      return null;                    // return null object if more or less than 5 Strings passsed
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
