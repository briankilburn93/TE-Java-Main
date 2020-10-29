package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")		//@RequestMapping is outside the controller class
public class AuctionController {	// This is the base path for all controllers

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
    
    @RequestMapping(path = "")	// handle the base path of /auction
    public List<Auction> list() {
    	
    }

}
