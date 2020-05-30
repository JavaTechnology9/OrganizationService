package com.javatechnology.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechnology.model.Organization;
import com.javatechnology.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository organizationRepository;
	
	public Organization getOrg(String orgId) {
		 Optional<Organization> findById = organizationRepository.findById(orgId);
		 return findById.get();
	}
	public Organization getOrganization() {
		Organization org= new Organization();
		org.setContactNumber("45678912587");
		org.setEmail("org@gmail.com");
		org.setId(UUID.randomUUID().toString());
		org.setName("OrganizationService");
		return org;
	}

}
