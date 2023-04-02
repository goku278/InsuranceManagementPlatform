package com.insurance.management.system.com.insurance.management.system.service;

import com.insurance.management.system.com.insurance.management.system.dao.ClaimRepo;
import com.insurance.management.system.com.insurance.management.system.dao.InsuranceRepo;
import com.insurance.management.system.com.insurance.management.system.entity.Claim;
import com.insurance.management.system.com.insurance.management.system.entity.Insurance;
import com.insurance.management.system.com.insurance.management.system.model.requestModel.PolicyModel;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRepo insuranceRepo;
    @Autowired
    ClaimRepo claimRepo;

    public ResponseEntity<?> createNewPolicy(PolicyModel policyModel) {
        Insurance i = new Insurance();
        i.setCoverageAmount(policyModel.getCoverageAmount());
        i.setEndDate(policyModel.getEndDate());
        i.setPolicyNumber(policyModel.getPolicyNumber());
        i.setPremium(policyModel.getPremium());
        i.setStartDate(policyModel.getStartDate());
        i.setPolicyType(policyModel.getPolicyType());

        insuranceRepo.save(i);
        return ResponseEntity.ok(new Status("200","Data saved"));
    }

    public ResponseEntity<?> getAllPolicies() {
        List<Insurance> insuranceList = insuranceRepo.findAll();
        return ResponseEntity.ok(insuranceList);
    }

    public ResponseEntity<?> getPolicy(Long id) {
        Insurance i = insuranceRepo.findById(id).orElse(null);
        if (i == null) return ResponseEntity.ok(new Status(HttpStatus.NOT_FOUND.toString(),"Data not found"));
        return ResponseEntity.ok(i);
    }

    public ResponseEntity<?> updatePolicy(Long id, PolicyModel p) {
        Insurance i = insuranceRepo.findById(id).orElse(null);
        if (i == null) return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        i.setPolicyType(p.getPolicyType());
        i.setPremium(p.getPremium());
        i.setPolicyNumber(p.getPolicyNumber());
        i.setStartDate(p.getStartDate());
        i.setEndDate(p.getEndDate());
        i.setCoverageAmount(p.getCoverageAmount());
        insuranceRepo.save(i);
        return ResponseEntity.ok(new Status(HttpStatus.OK.toString(), "Updated"));
    }

    public ResponseEntity<?> deletePolicy(Long id) {
        Insurance i = insuranceRepo.findById(id).orElse(null);
        if (i == null) return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        insuranceRepo.deleteById(id);
        return ResponseEntity.ok(new Status("200","DELETED"));
    }

    public ResponseEntity<?> issueAClaim(Long policyId, Long claimsId) {
        Insurance in = insuranceRepo.findById(policyId).orElse(null);
        Claim c = claimRepo.findById(claimsId).orElse(null);
        if (in == null || c == null) {
            return ResponseEntity.ok(new Status(HttpStatus.NOT_FOUND.toString(),"Data not found"));
        }
        if (in.getClaim() != null) {
            // Preventing multiple claims in a single policy......
            in.setClaim(null);
            c.setInsurance(null);
        }
        in.setClaim(c);
        c.setInsurance(in);
        insuranceRepo.save(in);
        return ResponseEntity.ok(new Status("200","Claim has been issued for this policy"));
    }
}
