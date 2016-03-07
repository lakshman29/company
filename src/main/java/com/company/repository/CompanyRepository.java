package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.domain.Company;

/**
 * 
 * @author Lakshman
 *
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer> {

}
