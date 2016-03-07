package com.company.service;

import java.util.List;
import java.util.Set;

import com.company.domain.Company;
import com.company.domain.Owner;
/**
 * 
 * @author Lakshman
 *
 */
public interface CompanyService {
	public List<Company> getAllCompanies();

	public Company getCompanyDetails(int companyID);

	public Company addCompany(Company company);

	public Company updateCompany(int companyID, String address);

	public Set<Owner> getOwnerDetails(int companyID);
}
