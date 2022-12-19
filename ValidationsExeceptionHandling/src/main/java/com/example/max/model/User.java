package com.example.max.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
//	@NotNull(message = "firstName не должно быть нулевым")
	private String firstName;
	@NotBlank
//	@NotNull(message = "lastName не должно быть нулевым")
	private String lastName;
	@NotBlank
	@Email(message = "неверный адрес электронной почты")
	private String email;
	@Min(18)
    @Max(60)
	private Integer age;
	@Pattern(regexp = "^\\d{10}$",message = "введен неверный номер мобильного телефона")
	private String mobile;
}
