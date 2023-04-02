package com.insurance.management.system.com.insurance.management.system.dao;

import com.insurance.management.system.com.insurance.management.system.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance, Long> {
}
