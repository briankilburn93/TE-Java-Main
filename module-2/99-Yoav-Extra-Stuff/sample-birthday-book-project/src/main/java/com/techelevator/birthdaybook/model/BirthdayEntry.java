package com.techelevator.birthdaybook.model;

import javax.validation.Valid;

public class BirthdayEntry {
	
	private Long id;
	
	private String name;
	
	private Integer birthDay;
	
	private Integer birthMonth;
	
	private Integer birthYear;
	
	private String notes;
	
	public BirthdayEntry() {
		
	}
	
	public BirthdayEntry(Long id, @Valid String name, @Valid Integer birthDay, @Valid Integer birthMonth,
			@Valid Integer birthYear, String notes) {
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.notes = notes;
	}
	
	public BirthdayEntry(@Valid String name, @Valid Integer birthDay, @Valid Integer birthMonth,
			@Valid Integer birthYear, String notes) {
		this.name = name;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.notes = notes;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDay
	 */
	public Integer getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Integer birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return the birthMonth
	 */
	public Integer getBirthMonth() {
		return birthMonth;
	}

	/**
	 * @param birthMonth the birthMonth to set
	 */
	public void setBirthMonth(Integer birthMonth) {
		this.birthMonth = birthMonth;
	}

	/**
	 * @return the birthYear
	 */
	public Integer getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	

}
