package com.example.phonebook.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;
	
	@Column(nullable = false)
	@NotEmpty(message = "contact name can not be empty")
	@Size(min = 4,max =25,message = "name size is in between min 4 to max 25")
	private String contactName;
	
	@Column(nullable = false)
	@NotEmpty(message = "contact can not be empty")
	@Size(min = 4, max = 25,message = "password has contains minimum 4 characters and maximum 25") 
    private String contactNumber;
	

	
}
