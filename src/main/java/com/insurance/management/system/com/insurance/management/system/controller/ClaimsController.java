package com.insurance.management.system.com.insurance.management.system.controller;

import com.insurance.management.system.com.insurance.management.system.model.requestModel.ClaimModel;
import com.insurance.management.system.com.insurance.management.system.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class ClaimsController {
    @Autowired
    ClaimService cs;

    @RequestMapping(value = "/api/claims", method = RequestMethod.POST)
    public ResponseEntity<?> createAClaim(@Valid @RequestBody ClaimModel c) {
        return cs.createANewClaim(c);
    }

    @RequestMapping(value = "/api/claims/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClaim(@Valid @PathVariable Long id) {
        if (id == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return cs.getClaim(id);
    }

    @RequestMapping(value = "/api/claims", method = RequestMethod.GET)
    public ResponseEntity<?> getClaims() {
        return cs.getClaims();
    }

    @RequestMapping(value = "/api/claims/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClaims(@Valid @RequestBody ClaimModel claimModel, @Valid @PathVariable Long id) {
        if (id == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return cs.updateClaims(claimModel, id);
    }

    @RequestMapping(value = "/api/claims/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClaims(@Valid @PathVariable Long id) {
        if (id == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return cs.deleteClaims(id);
    }
}
