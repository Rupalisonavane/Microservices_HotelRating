package org.coderRups.UserService.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tab_user")
public class User {

	@Id
	@Column(name="id")
	private String userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="about")
	private String about;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobileno")
	private String mobileno;
	
	@Transient
	private List<Rating> Rating=new ArrayList<>();
   
	
}
