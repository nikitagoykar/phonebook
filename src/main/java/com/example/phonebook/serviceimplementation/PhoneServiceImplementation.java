package com.example.phonebook.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import com.example.phonebook.entity.PhoneEntity;
import com.example.phonebook.exception.ResourceNotFoundException;
import com.example.phonebook.payload.PhoneDto;
import com.example.phonebook.repository.PhoneRepository;
import com.example.phonebook.service.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PhoneServiceImplementation implements PhoneService {



	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	

	@Override
	public PhoneDto createcontact(PhoneDto phoneDto) {
		// TODO Auto-generated method stub
		PhoneEntity contactEntity = this.modelMapper.map(phoneDto, PhoneEntity.class);
		PhoneEntity savecontact = this.phoneRepository.save(contactEntity);
		return this.modelMapper.map(savecontact, PhoneDto.class);
	}

	@Override
	public PhoneDto getcontactById(int contactId) {
		// TODO Auto-generated method stub
		PhoneEntity contact = this.phoneRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Phone", "contactId", contactId));
		return this.modelMapper.map(contact, PhoneDto.class);
	}

	@Override
	public List<PhoneDto> getAllcontacts() {
		// TODO Auto-generated method stub
		List<PhoneDto> getAllcontacts = this.phoneRepository.findAll().stream()
				.map(contact -> this.modelMapper.map(contact, PhoneDto.class)).collect(Collectors.toList());
		return getAllcontacts;
	}

	@Override
	public PhoneDto updatecontactById(PhoneDto phoneDto, int contactId) {
		// TODO Auto-generated method stub
		PhoneEntity contactEntity = this.phoneRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Phone", "contactId", contactId));
		PhoneEntity updatedcontactEntity = this.modelMapper.map(phoneDto, PhoneEntity.class);
		
		PhoneEntity savecontact = this.phoneRepository.save(updatedcontactEntity);

		return this.modelMapper.map(savecontact, PhoneDto.class);
	}

	@Override
	public void deletecontactById(int contactId) {
		// TODO Auto-generated method stub
		PhoneEntity contactEntity = this.phoneRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Phone", "contactId", contactId));
		this.phoneRepository.delete(contactEntity);
	
	}
	
	public PhoneEntity contactDtoTocontactEntity(PhoneDto phoneDto) {
		return this.modelMapper.map(phoneDto, PhoneEntity.class);
	}

	public PhoneDto contactEntityTocontactDto(PhoneEntity contactEntity) {
		return this.modelMapper.map(contactEntity, PhoneDto.class);
	}
	
	
}
