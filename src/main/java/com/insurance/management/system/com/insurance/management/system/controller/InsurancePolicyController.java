package com.insurance.management.system.com.insurance.management.system.controller;

import com.insurance.management.system.com.insurance.management.system.model.requestModel.PolicyModel;
import com.insurance.management.system.com.insurance.management.system.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class InsurancePolicyController {
    @Autowired
    InsuranceService i;

    @RequestMapping(value = "/api/policies", method = RequestMethod.POST)
    public ResponseEntity<?> createNewPolicy(@Valid @RequestBody PolicyModel policyModel) {
        return i.createNewPolicy(policyModel);
    }

    @RequestMapping(value = "/api/policies", method = RequestMethod.GET)
    public ResponseEntity<?> createNewPolicy() {
        return i.getAllPolicies();
    }

    @RequestMapping(value = "/api/policies/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> createNewPolicy(@Valid @PathVariable Long id) {
        if (id == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return i.getPolicy(id);
    }

    @RequestMapping(value = "/api/policies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePolicy(@Valid @PathVariable Long id, @Valid @RequestBody PolicyModel p) {
        if (id == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return i.updatePolicy(id, p);
    }

    @RequestMapping(value = "/api/policies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePolicy(@Valid @PathVariable Long id) {
        if (id == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return i.deletePolicy(id);
    }

    @RequestMapping(value = "/api/policies/{policyId}/{claimsId}", method = RequestMethod.PUT)
    public ResponseEntity<?> issueClaims(@Valid @PathVariable Long policyId, @Valid @PathVariable Long claimsId) {
        if (policyId == null || claimsId == null) return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        return i.issueAClaim(policyId, claimsId);
    }
}