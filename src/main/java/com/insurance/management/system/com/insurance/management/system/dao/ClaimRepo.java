package com.insurance.management.system.com.insurance.management.system.dao;

import com.insurance.management.system.com.insurance.management.system.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepo extends JpaRepository<Claim, Long> {
}
