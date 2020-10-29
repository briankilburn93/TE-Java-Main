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
    
    @RequestMapping(path = "", method = RequestMethod.GET)	// handle the base path of /auction
    public List<Auction> list(@RequestParam(value="title_like", defaultValue="") String title, @RequestParam(value="currentBid_lte", defaultValue="0", required = false) double maxPrice) {
    	
    	if(maxPrice != 0 && title.equals("") == false) {
    		return dao.searchByTitleAndPrice(title, maxPrice);
    	}
    	else if(maxPrice > 0) {
    		return dao.searchByPrice(maxPrice);
    	}
    	else if(title.equals("")) {
    		return dao.list();
    	}
    	else {
    		return dao.searchByTitle(title);
    	}
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	return dao.get(id);
    }
    
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction aAuction) {
    	
    	dao.create(aAuction);
    	
    	return aAuction;
    }
    
}
