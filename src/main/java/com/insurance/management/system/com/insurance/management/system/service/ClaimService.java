package com.insurance.management.system.com.insurance.management.system.service;

import com.insurance.management.system.com.insurance.management.system.dao.ClaimRepo;
import com.insurance.management.system.com.insurance.management.system.entity.Claim;
import com.insurance.management.system.com.insurance.management.system.model.requestModel.ClaimModel;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    @Autowired
    ClaimRepo claimRepo;
    public ResponseEntity<?> createANewClaim(ClaimModel c) {
        Claim clm = new Claim();
        clm.setClaimDate(c.getClaimDate());
        clm.setClaimNumber(c.getClaimNumber());
        clm.setClaimStatus(c.getClaimStatus());
        clm.setDescription(c.getDescription());
        claimRepo.save(clm);
        return ResponseEntity.ok(new Status(HttpStatus.OK.toString(),"Data created and saved"));
    }

    public ResponseEntity<?> getClaim(Long id) {
        Claim c = claimRepo.findById(id).orElse(null);
        if (c == null) return ResponseEntity.ok(new Status(HttpStatus.NOT_FOUND.toString(),"Data not found!"));
        return ResponseEntity.ok(c);
    }

    public ResponseEntity<?> getClaims() {
        List<Claim> claimList = claimRepo.findAll();
        return ResponseEntity.ok(claimList);
    }

    public ResponseEntity<?> updateClaims(ClaimModel claimModel, Long id) {
        Claim c = claimRepo.findById(id).orElse(null);
        if (c == null) {
            return ResponseEntity.ok(new Status(HttpStatus.NOT_FOUND.toString(),"Data not found!"));
        }
        c.setClaimStatus(claimModel.getClaimStatus());
        c.setClaimNumber(claimModel.getClaimNumber());
        c.setClaimDate(claimModel.getClaimDate());
        c.setDescription(claimModel.getDescription());
        claimRepo.save(c);
        return ResponseEntity.ok(new Status("200","UPDATED"));
    }

    public ResponseEntity<?> deleteClaims(Long id) {
        claimRepo.deleteById(id);
        return ResponseEntity.ok("DELETED");
    }
}
