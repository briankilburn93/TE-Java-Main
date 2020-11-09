package com.techelevator.rental;

import java.time.LocalDateTime;

public class Rental {
	/**********************************************************************************
	 * Data members
	 **********************************************************************************/

	private int           rentalId;
	private LocalDateTime rentalDate;  // timestamp in table
	private int           inventoryId;
	private int           customerId;
	private LocalDateTime returnDate;
	private int           staffId;
	
	/**********************************************************************************
	 * Constructors 
	 **********************************************************************************/
	
	/**
	 * Default constructor - required in case we (or Java need a default Rental object)
	 * 
	 * a Default Rental object should never be returned to the application program
	 */
	public Rental() {
		
		rentalId    = 0;     // unknown for a default Rental
		rentalDate  = null;  // unknown for a default Rental
		inventoryId = 0;     // unknown for a default Rental
		customerId  = 0;     // unknown for a default Rental
		returnDate  = null;  // unknown for a default Rental
		staffId     = 0;     // unknown for a default Rental
		
	}
	
	/**
	 * @param rentalId
	 * @param inventoryId
	 * @param customerId
	 * @param staffId
	 */
public Rental(int inventoryId, int customerId, int staffId) {

	this.rentalDate = LocalDateTime.now();
	this.inventoryId = inventoryId;
	this.customerId = customerId;
	this.returnDate = null;
	this.staffId = staffId;
}
	/**********************************************************************************
	 * Getters / Setters
	 **********************************************************************************/
	
	/**
	 * @return the rentalId
	 */
	public int getRentalId() {
		return rentalId;
	}

	/**
	 * @param rentalId the rentalId to set
	 */
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	/**
	 * @return the rentalDate
	 */
	public LocalDateTime getRentalDate() {
		return rentalDate;
	}

	/**
	 * @param rentalDate the rentalDate to set
	 */
	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	/**
	 * @return the inventoryId
	 */
	public int getInventoryId() {
		return inventoryId;
	}

	/**
	 * @param inventoryId the inventoryId to set
	 */
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the returnDate
	 */
	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the staffId
	 */
	public int getStaffId() {
		return staffId;
	}

	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	/**********************************************************************************
	 * Additional Overrides
	 **********************************************************************************/

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Rental other = (Rental) obj;
		if (customerId != other.customerId) {
			return false;
		}
		if (inventoryId != other.inventoryId) {
			return false;
		}
		if (rentalDate == null) {
			if (other.rentalDate != null) {
				return false;
			}
		} else if (!rentalDate.equals(other.rentalDate)) {
			return false;
		}
		if (rentalId != other.rentalId) {
			return false;
		}
		if (returnDate == null) {
			if (other.returnDate != null) {
				return false;
			}
		} else if (!returnDate.equals(other.returnDate)) {
			return false;
		}
		if (staffId != other.staffId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Rental [rentalId=" + rentalId + ", rentalDate=" + rentalDate + ", inventoryId=" + inventoryId
				+ ", customerId=" + customerId + ", returnDate=" + returnDate + ", staffId=" + staffId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + inventoryId;
		result = prime * result + ((rentalDate == null) ? 0 : rentalDate.hashCode());
		result = prime * result + rentalId;
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + staffId;
		return result;
	}



}
