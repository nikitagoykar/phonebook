package com.example.phonebook.service;

import java.util.List;

import com.example.phonebook.payload.PhoneDto;


public interface PhoneService {
public PhoneDto createcontact(PhoneDto phoneDto);
	
	public PhoneDto getcontactById(int contactId);
	
	public List<PhoneDto> getAllcontacts();
	
	public PhoneDto updatecontactById(PhoneDto phoneDto, int contactId);
	
	public void deletecontactById(int contactId);

}
