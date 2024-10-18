package com.example.phonebook.controller;

import java.util.List;

import com.example.phonebook.exception.ApiResponce;
import com.example.phonebook.payload.PhoneDto;
import com.example.phonebook.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")

public class PhoneController {


	@Autowired
	private PhoneService phoneService; 

	// add Phone 
	@PostMapping("/contact")
	private ResponseEntity<PhoneDto> createcontact(@RequestBody PhoneDto phoneDto) {
		PhoneDto createdcontact = this.phoneService.createcontact(phoneDto);
		return new ResponseEntity<PhoneDto>(createdcontact, HttpStatus.CREATED);
	}

	// Fetch Phone record by contactById
	@GetMapping("/contact/{contactId}")
	ResponseEntity<PhoneDto> createHostel(@PathVariable int contactId) {
		PhoneDto recivedcontact = this.phoneService.getcontactById(contactId);
		return new ResponseEntity<PhoneDto>(recivedcontact, HttpStatus.OK);
	}

	//Fetch all Phone record by Allcontacts
	@GetMapping("/contact")
	ResponseEntity<List<PhoneDto>> createcontact() {
		List<PhoneDto> recivedAllcontacts = this.phoneService.getAllcontacts();
		return new ResponseEntity<List<PhoneDto>>(recivedAllcontacts, HttpStatus.OK);
	}

	// update contact record contactById
	@PutMapping("/contact/{contactId}")
	ResponseEntity<PhoneDto> updatecontactById(@RequestBody PhoneDto phoneDto, @PathVariable int contactId) {
		PhoneDto updatedcontact = this.phoneService.updatecontactById(phoneDto, contactId);
		return new ResponseEntity<PhoneDto>(updatedcontact, HttpStatus.OK);
	}
	
	//delete contact record by contactId
	@DeleteMapping("/contact/{contactId}")
	ResponseEntity<ApiResponce>deletecontact(@PathVariable int contactId)
	{
		this.phoneService.deletecontactById(contactId);
		ApiResponce responce = new ApiResponce();
		responce.setMessage("Phone deleted succesfully");
		responce.setSucess(true);
		return new ResponseEntity<ApiResponce>(responce,HttpStatus.OK);
	}
	}