package com.javatechnology.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatechnology.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String>{

}
