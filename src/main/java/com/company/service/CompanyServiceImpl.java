package com.company.service;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.company.domain.Company;
import com.company.domain.Owner;
import com.company.repository.CompanyRepository;

/**
 * 
 * @author Lakshman
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Inject
	CompanyRepository companyRepository;



	/* (non-Javadoc)
	 * @see com.company.service.CompanyService#getAllCompanies()
	 */
	@Override
	@Transactional
	public List<Company> getAllCompanies() {

		return (List<Company>) companyRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.company.service.CompanyService#getCompanyDetails(int)
	 */
	@Override
	@Transactional
	public Company getCompanyDetails(int companyID) {
		
		return companyRepository.findOne(companyID);
	}

	/* (non-Javadoc)
	 * @see com.company.service.CompanyService#addCompany(com.company.domain.Company)
	 */
	@Override
	@Transactional
	public Company addCompany(Company company) {
		
		return companyRepository.save(company);
	}

	/* (non-Javadoc)
	 * @see com.company.service.CompanyService#updateCompany(int, java.lang.String)
	 */
	@Override
	@Transactional
	public Company updateCompany(int companyID, String address) {
		Company company = companyRepository.findOne(companyID);
		return companyRepository.save(company);
	}

	/* (non-Javadoc)
	 * @see com.company.service.CompanyService#getOwnerDetails(int)
	 */
	@Override
	@Transactional
	public Set<Owner> getOwnerDetails(int companyID) {
		Company company = companyRepository.findOne(companyID);
		return company.getOwner();
	}

}
