package com.example.phonebook.repository;

import com.example.phonebook.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PhoneRepository extends JpaRepository<PhoneEntity,Integer>{

	
}
