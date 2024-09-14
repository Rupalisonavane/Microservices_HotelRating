package org.coderRups.UserService.entity;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Hotel {
	private String id;
	private String name;
	private String location;
	private String about;
}
