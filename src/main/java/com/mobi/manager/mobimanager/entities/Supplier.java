package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supplier")
@Getter
@Setter
public class Supplier extends BaseEntity {

	@Column(name = "supplier_name", nullable = false, length = 100)
	private String supplier_name;

	@Column(name = "mobile_number", nullable = false, length = 50)
	private String mobileNumber;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "name", column = @Column(name = "location_name"))
	})
	private Location location;

}
