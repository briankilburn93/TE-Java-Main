package com.techelevator.city;

public class City {
// POJO has standard getters/setters (let Eclipse generate)
// standard getter - name getColumnName (or isBoolenColumnName)
// standard setter - name setColumnName, accepts only on parameter, returns void
// POJOs are not required to have a constructor
//
// one instance variable for every column
// datatypes must match (be compatible) with the table column data types
	
	private Long id;            // serial in the table
	private String name;        // any type with the word 'char' in the table
	private String countryCode; // any type with the word 'char' in the table
	private String district;    // any type with the word 'char' in the table
	private int population;     // any type with the word 'int' in the table
	                            // any type with the word 'float' in the table is a double
                                // type numeric in the table is a double or BigDecimal
	
// standard getter/setters  getVariableName / setVariableName
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
}
