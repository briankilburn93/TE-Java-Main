package com.techelevator.hotels.models;

public class LoginDTO {

	// used to interact with the login process
	
    private String username;
    private String password;
    
    //  credentials: "username,password"
    public LoginDTO(String credentials) { // Ctor for LoginDTO
        String[] parts = credentials.split(",");
        username = parts[0];
        password = parts[1];
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

