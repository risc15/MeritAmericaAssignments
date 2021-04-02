/*
 * User.java
 * =============
 * 
 * This entity is used to track user information - in this case, their names and job
 * descriptions.
 * 
 * My Notes:
 * ==============
 * 
 * @Entity is a JPA annotation that denotes the whole class for storage in a relational table.
 * 
 * @Id and @GeneratedValue are JPA annotations to note the primary key and that is generated
 * automatically when needed.
 * 
 * Spring Data REST is not confined to JPA. It supports many NoSQL data stores as well.
 * 
 */

package com.meritamerica.userlist.models;

import java.util.Objects;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
// Instance Variables:
	@Id 
	@GeneratedValue
	//(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column
	private String firstName;
	
	//@Column
	private String lastName;
	
	//@Column
	private String description;
	
	//@Column
	private String email;
	
// Constructors:
	
	// Empty constructor needed for some reason:
	private User() {
		
	}

	public User(String firstName, String lastName, String description, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.email = email;
	}
	
// Getters / Setters:

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
// Methods:
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) &&
			Objects.equals(firstName, user.firstName) &&
			Objects.equals(lastName, user.lastName) &&
			Objects.equals(description, user.description) &&
			Objects.equals(email,  user.email);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, description, email);
	}
	
// To String:
	
	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", description='" + description + '\'' +
			", email='" + email + '\'' +
			'}';
	}

}
