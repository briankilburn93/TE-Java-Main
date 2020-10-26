package com.techelevator.hotels;

//POJO for Hotel data being returned from our API call
// To easily gain access to data returned form an API
// we need a POJO - further details will be forthcoming later in class

public class Review {
    private int hotelID;
    private String title;
    private String review;
    private String author;
    private int stars;

    public Review() {	// default ctr is required for a POJO
    }    				//	we have nothing to initialize so this ctr is empty

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Review Details" +
                "\n--------------------------------------------" +
                "\n Hotel ID: " + hotelID +
                "\n Title:'" + title +
                "\n Review: " + review +
                "\n Author: " + author +
                "\n Stars: " + stars;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
