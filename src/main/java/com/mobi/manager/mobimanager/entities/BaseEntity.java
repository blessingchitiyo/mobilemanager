package com.mobi.manager.mobimanager.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	@Column(name = "dateModified", nullable = false)
	private LocalDateTime dateModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

}
