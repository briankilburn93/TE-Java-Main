package com.techelevator.birthdaybook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.BaseTest;
import com.techelevator.birthdaybook.dao.BirthdayEntryDAO;
import com.techelevator.birthdaybook.model.BirthdayEntry;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringBootTest
public class BirthdayBookControllerTests {
	
	@Autowired
	BirthdayBookController controller;
	
	@Autowired
    ObjectMapper mapper;
	
	@Autowired
	BirthdayEntryDAO dao;

    MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
        System.out.println("setup()...");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void getEntries_withData_shouldReturnData() throws Exception {
    	BirthdayEntry entry1 = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	BirthdayEntry entry2 = BaseTest.getBirthdayEntry("Test2", 1, 2, 1990, "Note2");
    	
    	dao.create(entry1);
    	dao.create(entry2);
    	
        mockMvc.perform(get("/birthdayentries")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(Matchers.greaterThan(1))));	
    }
    
    @Test
    public void getEntry_withValidId_shouldReturnData() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
        
        mockMvc.perform(get("/birthdayentries/" + savedEntry.getId()) 
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(savedEntry)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test1"));
    }
    
    @Test
    public void getEntry_withInvalidId_shouldReturnNotFoundStatus() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
        
        mockMvc.perform(get("/birthdayentries/" + savedEntry.getId() + 2)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(entry)))
                .andExpect(status().isNotFound());
    }
    
    @Test
    public void createEntry_withValidData_shouldCreateRecord() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");    	
        
        mockMvc.perform(post("/birthdayentries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(entry)))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void createEntry_withInvalidData_shouldReturnBadRequest() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 99, 2, 1980, "Note1");    	
        
        mockMvc.perform(post("/birthdayentries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(entry)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void update_withValidData_shouldReturnData() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
    	
    	savedEntry.setName("Updated!");
        
        mockMvc.perform(put("/birthdayentries/" + savedEntry.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(savedEntry)))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/birthdayentries/" + savedEntry.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(entry)))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.name").value("Updated!"));
    }
    
    @Test
    public void update_withInvalidData_shouldReturnBasdRequst() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
    	
    	savedEntry.setName("");
        
        mockMvc.perform(put("/birthdayentries/" + savedEntry.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(savedEntry)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void update_withInvalidData_shouldReturnNotFound() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
    	
    	savedEntry.setName("Updated!");
        
        mockMvc.perform(put("/birthdayentries/" + (savedEntry.getId() + 1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(savedEntry)))
                .andExpect(status().isNotFound());
    }
    
    @Test
    public void delete_withValidId_shouldReturnNoContent() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
    	
    	savedEntry.setName("Updated!");
        
        mockMvc.perform(delete("/birthdayentries/" + savedEntry.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(savedEntry)))
                .andExpect(status().isNoContent());
    }
    
    @Test
    public void delete_withInvalidId_shouldReturnNotFound() throws Exception {
    	BirthdayEntry entry = BaseTest.getBirthdayEntry("Test1", 1, 2, 1980, "Note1");
    	
    	BirthdayEntry savedEntry = dao.create(entry);
    	
    	savedEntry.setName("Updated!");
        
        mockMvc.perform(delete("/birthdayentries/" + (savedEntry.getId() + 1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(savedEntry)))
                .andExpect(status().isNotFound());
    }
    
    private String toJson(BirthdayEntry entry) throws JsonProcessingException {
        return mapper.writeValueAsString(entry);
    }

}
