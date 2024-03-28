package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supplier")
@Getter
@Setter
public class Supplier extends BaseEntity {

	@Column(name = "supplierName", nullable = false, length = 100)
	private String supplierName;

	@Column(name = "mobileNumber", nullable = false, length = 50)
	private String mobileNumber;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "name", column = @Column(name = "locationName"))
	})
	private Location location;

}
