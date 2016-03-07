package com.company.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Entity
public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3863494274246860762L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyId_SEQ")
	@SequenceGenerator(name = "companyId_SEQ", sequenceName = "companyId_SEQ", allocationSize = 1)
	private int companyId;
	private String name;
	private String address;
	private String city;
	private String country;
	private String eMail;
	private String phoneNumber;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE },orphanRemoval=true)
	private Set<Owner> owner= new HashSet<Owner>();

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Owner> getOwner() {
		return owner;
	}

	public void setOwner(Set<Owner> owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name
				+ ", address=" + address + ", city=" + city + ", country="
				+ country + ", eMail=" + eMail + ", phoneNumber=" + phoneNumber
				+ ", owner=" + owner + "]";
	}

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Company obj = new Company();
		mapper.writeValueAsString(obj);
	}

}
