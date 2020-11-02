package com.techelevator.hotels.services;

import com.techelevator.hotels.models.LoginDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

public class AuthenticationService {

    private String BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    private ConsoleService console = new ConsoleService();

    public AuthenticationService(String url) {
        this.BASE_URL = url;
    }

    public ResponseEntity<Map> login(String credentials) throws AuthenticationServiceException {
        // LoginDTO - class for a object that is used to transfer data to and from an API
    	// Data Transfer Object - An object whose sole purpose to interact with an external data source
    	// A DTO usually does get processed in the App as it really doesn't have any app data
    	LoginDTO loginDTO = new LoginDTO(credentials);

    	// Create header required for API class
    	HttpHeaders headers = new HttpHeaders();
        // Set the content for the request 
     	headers.setContentType(MediaType.APPLICATION_JSON);
        // Creating the entity for the request - combine the headers with data object
        HttpEntity<LoginDTO> entity = new HttpEntity<>(loginDTO, headers);
        // Define an reference to hold the response from API call
        ResponseEntity<Map> response = null;
        try {
        	// Call the login API with POST and the entity created above
        	// Store the response from the API in a Map (defined above)
            response = restTemplate.exchange(BASE_URL + "/login", HttpMethod.POST, entity, Map.class);
        } catch(RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getResponseBodyAsString().length() == 0) {
                String message = ex.getRawStatusCode() + " : {\"timestamp\":\"" + LocalDateTime.now() + "+00:00\",\"status\":401,\"error\":\"Invalid credentials\",\"message\":\"Login failed: Invalid username or password\",\"path\":\"/login\"}";
                throw new AuthenticationServiceException(message);
            }
            else {
                String message = ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString();
                throw new AuthenticationServiceException(message);
            }
        }
        return response;
    }

}
