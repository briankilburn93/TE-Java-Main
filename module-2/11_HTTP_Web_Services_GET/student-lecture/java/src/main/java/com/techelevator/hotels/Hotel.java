package com.techelevator.hotels;

public class Hotel {
	
	//POJO for Hotel data being returned from our API call
	// To easily gain access to data returned form an API
	// we need a POJO - further details will be forthcoming later in class

    private int id;
    private String name;
    private int stars;
    private int roomsAvailable;
    private String coverImage;

    public Hotel() {}	// default ctr is required for a POJO
    					//	we have nothing to initialize so this ctr is empty

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name:'" + name + '\'' +
                "\n Stars: " + stars +
                "\n RoomsAvailable: " + roomsAvailable +
                "\n overImage" + coverImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }
}
