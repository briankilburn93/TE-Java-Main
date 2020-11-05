package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

// implement the methods for DAO - all interface methods must be implements
// additional outside the interface may be added

public class JDBCCityDAO implements CityDAO {  // concrete class is named JDBCtablenameDAO

	private JdbcTemplate myJdbcTemplate;  // declare an JdbcTemplate Spring DAO object
	
	// constructor that takes datasource and assigns to JdbcTemplate object
	// User is expected to define the datasource and pass it to the constructor
	
	public JDBCCityDAO(DataSource aDataSource) {
		this.myJdbcTemplate = new JdbcTemplate(aDataSource);  // instantiate and initialize JdbcTemplate with datasource
	}

	@Override
	public void save(City newCity) {  // add a new city from a City object
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";
		// WE will get the next value for CityID from the database and store it in the Object the User passed us
		newCity.setId(getNextCityId());  // Go get the next serial value for the City table CityID 
		                                 //    and store in the City object passed to us.
		                                 //    So when the user calls us to save hey know what CityId was assigned
		
		myJdbcTemplate.update(sqlInsertCity, newCity.getId(),          // get the value from the object passed in
										     newCity.getName(),        // get the value from the object passed in
										     newCity.getCountryCode(), // get the value from the object passed in
										     newCity.getDistrict(),    // get the value from the object passed in
										     newCity.getPopulation()); // get the value from the object passed in
	}
	
	@Override
	public City findCityById(long id) {
		
		City theCity = null;    // Default object returned if a non-exiting city is requested
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {                // if a City was found
			theCity = mapRowToCity(results);//    Set the City to the values retrieved and return it
			                                //    Map mapRowToCity will create a City object and populate 
			                                //        with values from the table
		}
		return theCity;                     // if not found, return the null City object we defined at the start of method
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();  // Returned from method - ArrayList if case there is more than one
		
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";

		// When a queryForRowSet is done, the result of the SELECT is returned in an SqlRowSet object
		// an SqlRowSet keeps track of the current row in the set using a cursor
		// Initially the cursor points to BEFORE THE FIRST ROW
		// next() method moves the cursor to the next row and retrieve it
		//
		// TLDR: do a next() after the queryForRowSet to see if anything was returned and retrieve 1st row
		//       an Exception will occur if you try to retrieve data and you have not done a next()
		
		SqlRowSet results = myJdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);

		while(results.next()) {  // Loop while there is a row in the result and retrieve the current row
			City theCity = mapRowToCity(results);  // Copy the data from the row into a POJO object
			cities.add(theCity);                   // Add the POJO to the ArrayList being returned
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	private long getNextCityId() {   // get the next value from a sequence object 
		SqlRowSet nextIdResult = myJdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {    // No loop needed to get result from SELECT - only one row will come back
			return nextIdResult.getLong(1);  // Get the value returned from the first column in the SELECT - 
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	private City mapRowToCity(SqlRowSet results) {   // Copy all the values from result into a new City object return it
		                                             // This method expects results to include all columns in the table
		                                             // Be sure all data expected by method is in the result from SQL
		City theCity;          // define object to return
		theCity = new City();  // instantiate and initialize object to default values
		
		theCity.setId(results.getLong("id"));                     // copy id from the result to id in object
		theCity.setName(results.getString("name"));               // copy name from the result to name in object
		theCity.setCountryCode(results.getString("countrycode")); // copy countrycode from the result to countrycode in object
		theCity.setDistrict(results.getString("district"));       // copy district from the result to district in object
		theCity.setPopulation(results.getInt("population"));      // copy population from the result to population in object

  		return theCity;       // return the object with the data from the SQL results
	}

	@Override
	public List<City> allCities() {
		// TODO Auto-generated method stub
		return null;
	}

	}

