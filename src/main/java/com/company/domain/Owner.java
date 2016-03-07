package com.company.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


/**
 * This class contains Owner entity
 */

@Entity
public class Owner implements Serializable {
	
	private static final long serialVersionUID = 4207954061960793056L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownerId_SEQ")
	@SequenceGenerator(name = "ownerId_SEQ", sequenceName = "ownerId_SEQ", allocationSize = 1)
	private int ownerId;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	private String ownerName;

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
