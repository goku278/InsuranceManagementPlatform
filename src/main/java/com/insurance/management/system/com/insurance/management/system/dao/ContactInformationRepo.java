package com.insurance.management.system.com.insurance.management.system.dao;

import com.insurance.management.system.com.insurance.management.system.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepo extends JpaRepository<ContactInformation, Long> {
}
