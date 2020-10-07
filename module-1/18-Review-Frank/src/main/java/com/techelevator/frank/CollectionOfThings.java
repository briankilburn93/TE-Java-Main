package com.techelevator.frank;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CollectionOfThings {
	
	public static enum ITEM_TYPE {VINYL, COIN, STAMP, WINE, THING };
	
	Map<ITEM_TYPE,List<CollectionItem>> itemsInCollection;

	public CollectionOfThings() throws FileNotFoundException {
		
		itemsInCollection = new HashMap<ITEM_TYPE,List<CollectionItem>>();
		
		loadCollectionFromFile();	
	}

	public void addItem(char itemCode, CollectionItem anItem) {
		
		ITEM_TYPE itemType = ITEM_TYPE.THING;
		
		switch (itemCode) {
			case 'v': 
			case 'V':
				itemType = ITEM_TYPE.VINYL;
				break;
			case 'c': 
			case 'C':
				itemType = ITEM_TYPE.COIN;
				break;
			case 's': 
			case 'S':
				itemType = ITEM_TYPE.STAMP;
				break;
			case 'w': 
			case 'W':
				itemType = ITEM_TYPE.WINE;
				break;
			default:
				itemType = ITEM_TYPE.THING;
		}
		List<CollectionItem> listOfItems = new ArrayList<>();
		if (itemsInCollection.containsKey(itemType)) {
			listOfItems = itemsInCollection.get(itemType);
		}
		listOfItems.add(anItem);
		itemsInCollection.put(itemType, listOfItems);
		}
	
	public void displayCollection() {
		
		Set<ITEM_TYPE> theKeys = itemsInCollection.keySet();
		
		for(ITEM_TYPE anItemKey : theKeys) {
			List<CollectionItem> theItems = itemsInCollection.get(anItemKey);
			
			System.out.println("\nThere are " 
			                  + itemsInCollection.get(anItemKey).size() 
			                  + " " + anItemKey 
			                  + " items in the Collection");
			
			for (CollectionItem anItem : theItems)
				System.out.println(anItem);
		}
	}
	
	private void loadCollectionFromFile() throws FileNotFoundException  {
	
		File collectionFile = new File("collection.txt");
		Scanner theCollectionFile = new Scanner(collectionFile);
	
		while (theCollectionFile.hasNextLine()) {
			String theLine = theCollectionFile.nextLine();
			if (theLine.startsWith("*")) {
				continue;
			}
			String lineFields[] = theLine.split("\\|");
		
			switch (lineFields[0]) {
				case "C":
					addCoin2Collection(lineFields);
					break;
				case "W":
					addWine2Collection(lineFields);
					break;
				case "V":
					addVinyl2Collection(lineFields);
					break;
			}
		
//		System.out.println("--------------------------");
//		for (String aField : lineFields) {
//			System.out.println(aField);
//		}
		}
			theCollectionFile.close();
	}
	
	public CollectionItem addCoin2Collection(String[] fieldsInLine) {
		String[] dateParts = fieldsInLine[2].split("/");
		LocalDate purchaseDate =  LocalDate.of(Integer.parseInt(dateParts[2])
				                             , Integer.parseInt(dateParts[0])
				                            , Integer.parseInt(dateParts[1]));
		
		int purchaseAmt = (int) (Double.parseDouble(fieldsInLine[3]) * 100);
		
		Coin aCoin = new Coin (fieldsInLine[1]
				              ,purchaseDate
				              ,purchaseAmt
				              ,Boolean.parseBoolean(fieldsInLine[4])
				              ,Integer.parseInt(fieldsInLine[5])
				              ,fieldsInLine[6].charAt(0)
				              ,fieldsInLine[7]
				              ,fieldsInLine[8]);	
		
		addItem(fieldsInLine[0].charAt(0), aCoin);
		
		return aCoin;
	}
	
	private void addWine2Collection(String[] fieldsInLine) {
		// TODO - Add Wine item to collection
	}
	
	private void addVinyl2Collection(String[] fieldsInLine) {
		// TODO - Add Vinyl item to collection
	}
	
	}
	
	

