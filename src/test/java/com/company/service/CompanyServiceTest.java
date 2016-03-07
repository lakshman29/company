package com.company.service;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Application;
import com.company.domain.Company;
import com.company.domain.Owner;
import com.company.service.CompanyService;
@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes =Application.class)
public class CompanyServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@Inject
	CompanyService companyService;

	@Test
	@Transactional
	public void test() {
		Company company = new Company();
		company.setAddress("madipakkam");
		company.setCity("chennai");
		company.setPhoneNumber("12344");
		company.setCountry("India");
		company.seteMail("test");
		company.setName("Lakshman");
		
		Owner owner = new Owner();
		owner.setOwnerName("one");
		Set<Owner> ownerList= new HashSet<Owner>();
		ownerList.add(owner);
		company.setOwner(ownerList);
		companyService.addCompany(company);
	}

}
