package com.insurance.management.system.com.insurance.management.system.dao;

import com.insurance.management.system.com.insurance.management.system.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
