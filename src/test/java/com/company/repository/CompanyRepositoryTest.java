package com.company.repository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.domain.Company;
import com.company.domain.Owner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {com.company.config.RepositoryConfiguration.class})
public class CompanyRepositoryTest {
	
	@Inject
	private CompanyRepository companyRepository;
	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	Company company;
	@Before
	public void setup() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		 company = new Company();
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
		System.out.println(mapper.writeValueAsString(company));
	}
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
		
		company=companyRepository.save(company);
	}

}
