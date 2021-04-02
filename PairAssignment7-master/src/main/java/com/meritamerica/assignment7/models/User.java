package com.meritamerica.assignment7.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="user_accounts")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private boolean active;
	
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private AccountHolder accountHolder;
	
	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Getters
	
	public long getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	@JsonBackReference(value="users")
	public AccountHolder getAccountHolder() {
		return this.accountHolder;
	}
	
	//Setters
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return true;
	}

	public Set<Role> getRoles() {
		// TODO Auto-generated method stub
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setActive(boolean active) {
		// TODO Auto-generated method stub
		this.active = active;
		
	}

	

	
}
