package com.srinivasalu.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srinivasalu.employee.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
