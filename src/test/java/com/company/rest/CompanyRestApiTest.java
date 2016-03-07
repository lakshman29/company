package com.company.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.company.domain.Company;
import com.company.domain.Owner;
import com.company.rest.CompanyRestApi;
import com.company.service.CompanyService;
/**
 * 
 * @author Lakshman
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class CompanyRestApiTest {
	@Inject
	CompanyRestApi companyrestApi;
	@Inject
	CompanyService companyService;
	
	
	@Test
	@Transactional
	public void testWholeMethods(){
		Company company;
		company=testAddCompany();
		testGetCompany();
		testgetOwnerDetails();
		testAllCompanies();
		testUpdateCompany();
	}

	//@Test
	@Transactional
	public Company testAddCompany() {

		Response reponse = companyrestApi.addComany(getCompany());
		Assert.assertNotNull(reponse);
		return (Company) reponse.getEntity();
	}

	//@Test
	@Transactional
	public Company testGetCompany() {

		Response reponse = companyrestApi.getCompanyDetails(1);
		Assert.assertNotNull(reponse);
		return (Company) reponse.getEntity();

	}

	//@Test
	@Transactional
	public Set<Owner> testgetOwnerDetails() {

		Response reponse = companyrestApi.getOwner(1);
		Assert.assertNotNull(reponse);
		Set<Owner> owner= (Set<Owner>) reponse.getEntity();
		return owner;

	}

	//@Test
	@Transactional
	public List<Company> testAllCompanies() {

		Response reponse = companyrestApi.getAllCompanies();
		Assert.assertNotNull(reponse);
		return (List<Company>) reponse.getEntity();

	}

	//@Test
	@Transactional
	public Company testUpdateCompany() {

		Response reponse = companyrestApi.updateCompany(1, "anna nagar");
		Assert.assertNotNull(reponse);
		return (Company) reponse.getEntity();

	}

	public Company getCompany() {
		Company company = new Company();
		company.setAddress("madipakkam");
		company.setCity("chennai");
		company.setPhoneNumber("9952627133");
		company.setCountry("India");
		company.seteMail("lakdhman29@gmail.com");
		company.setName("software org");

		Owner owner = new Owner();
		owner.setOwnerName("JOhn");
		Owner owner1 = new Owner();
		owner.setOwnerName("ashwin");
		Set<Owner> ownerList = new HashSet<Owner>();
		ownerList.add(owner);
		ownerList.add(owner1);
		company.setOwner(ownerList);
		owner.setCompany(company);
		return company;
	}

}
