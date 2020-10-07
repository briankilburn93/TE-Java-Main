package com.techelevator.frank;

import java.time.LocalDate;

public class CollectionItem {
	
	private String itemName;
	private LocalDate whenAddedToCollection;
	private int purchaseAmt;
	private boolean willingToSell;
	
	public CollectionItem(String itemName, LocalDate whenAddedToCollection, int purchaseAmt, boolean willingToSell) {

		this.itemName = itemName;
		this.whenAddedToCollection = whenAddedToCollection;
		this.purchaseAmt = purchaseAmt;
		this.willingToSell = willingToSell;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public LocalDate getWhenAddedToCollection() {
		return whenAddedToCollection;
	}

	public void setWhenAddedToCollection(LocalDate whenAddedToCollection) {
		this.whenAddedToCollection = whenAddedToCollection;
	}

	public int getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(int purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public boolean isWillingToSell() {
		return willingToSell;
	}

	public void setWillingToSell(boolean willingToSell) {
		this.willingToSell = willingToSell;
	}

	@Override
	public String toString() {
		return "CollectionItem [itemName=" + itemName + ", whenAddedToCollection=" + whenAddedToCollection
				+ ", purchaseAmt=" + purchaseAmt + ", willingToSell=" + willingToSell + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + purchaseAmt;
		result = prime * result + ((whenAddedToCollection == null) ? 0 : whenAddedToCollection.hashCode());
		result = prime * result + (willingToSell ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectionItem other = (CollectionItem) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (purchaseAmt != other.purchaseAmt)
			return false;
		if (whenAddedToCollection == null) {
			if (other.whenAddedToCollection != null)
				return false;
		} else if (!whenAddedToCollection.equals(other.whenAddedToCollection))
			return false;
		if (willingToSell != other.willingToSell)
			return false;
		return true;
	}
	
	
	
}
