package com.company.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.company.domain.Company;
import com.company.service.CompanyService;

/**
 * 
 * @author Lakshman
 *
 *         This class Responsible for Store and displaying Company information
 *         to Customer
 */

@Path("/")
@Component
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyRestApi {

	@Inject
	private CompanyService companyService;

	/**
	 * @return the all company information
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/companies")
	public Response getAllCompanies() {
		System.out.println(companyService.getAllCompanies());
		return Response.ok(companyService.getAllCompanies()).build();
	}

	/**
	 * @param companyID
	 * @return company information based on company id
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/company/{id}")
	public Response getCompanyDetails(@PathParam(value = "id") int companyID) {

		return Response.ok(companyService.getCompanyDetails(companyID)).build();
	}

	/**
	 * @param companyID
	 * @param address
	 * @return updated company information
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/company/{id}/{address}")
	public Response updateCompany(@PathParam(value = "id") int companyID,
			@PathParam(value = "address") String address) {

		return Response.ok(companyService.updateCompany(companyID, address))
				.build();
	}

	/**
	 * @param company
	 * @return newly added company infromation to customer
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addCompany")
	public Response addComany(Company company) {
		System.out.println("company" + company);
		return Response.ok(companyService.addCompany(company)).build();
	}

	/**
	 * @param companyID
	 * @return owner details of company
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getOwner/{id}")
	public Response getOwner(@PathParam(value = "id") int companyID) {
		System.out.println("company" + companyID);
		return Response.ok(companyService.getOwnerDetails(companyID)).build();
	}
}
