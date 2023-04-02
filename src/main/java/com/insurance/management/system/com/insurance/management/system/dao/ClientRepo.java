package com.insurance.management.system.com.insurance.management.system.dao;

import com.insurance.management.system.com.insurance.management.system.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
