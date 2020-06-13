package com.javatechnology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatechnology.model.Organization;
import com.javatechnology.service.OrganizationService;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationServicecontroller {
	@Autowired
	private OrganizationService  organizationService;
	
	@RequestMapping(value="/{organizationid}")
	public Organization getOrganization() {
		
		return organizationService.getOrganization();
		
	}
	@RequestMapping(value="/{organizationid}",method=RequestMethod.POST)
	public void saveOrganization(Organization organization) {
		organizationService.saveOrganization(organization);
	}
	

}
