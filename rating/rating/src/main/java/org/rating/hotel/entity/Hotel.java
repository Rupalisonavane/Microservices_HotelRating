package org.rating.hotel.entity;



import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tab_hotel")
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;

}
