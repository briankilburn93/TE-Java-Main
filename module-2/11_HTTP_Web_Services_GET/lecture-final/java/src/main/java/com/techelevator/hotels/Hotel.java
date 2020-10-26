package com.techelevator.hotels;

public class Hotel {

	// the names of the data members must match the JSON element names you want to associate them with
    private int id;
    private String name;
    private int stars;
    private int roomsAvailable;
    private String coverImage;

    public Hotel() {}  // default constructor is required for a POJO -
                       //     we have nothing to initialize so this ctor is empty.

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
