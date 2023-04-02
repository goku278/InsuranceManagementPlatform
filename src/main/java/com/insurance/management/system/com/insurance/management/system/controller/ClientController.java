package com.insurance.management.system.com.insurance.management.system.controller;

import com.insurance.management.system.com.insurance.management.system.model.requestModel.AddressAndContactModel;
import com.insurance.management.system.com.insurance.management.system.model.requestModel.ClientModel;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.Status;
import com.insurance.management.system.com.insurance.management.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    ClientService cs;

    @RequestMapping(value = "/api/clients", method = RequestMethod.POST)
    public ResponseEntity<?> saveClientDetails(@Valid @RequestBody ClientModel clientModel) {
        return cs.saveClientData(clientModel);
    }

    @RequestMapping(value = "/api/clients", method = RequestMethod.GET)
    public ResponseEntity<?> getAllClientData() {
        return cs.fetchAllClientsData();
    }

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllClientData(@Valid @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.ok(new Status(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Problem occurred"));
        }
        return cs.fetchClientData(id);
    }

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClientsData(@Valid @PathVariable Long id, @Valid @RequestBody AddressAndContactModel a) {
        if (id == null) {
            return ResponseEntity.ok(new Status(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Problem occurred"));
        }
        return cs.updateClientsData(id, a);
    }

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClientData(@Valid @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.ok(new Status(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Problem occurred"));
        }
        return cs.deleteClientData(id);
    }

    /**
     * Give each client a policy who are registered in this Insurance Policy management system.
     **/

    @RequestMapping(value = "/api/clients/{clientId}/{policyId}", method = RequestMethod.PUT)
    public ResponseEntity<?> issuePolicyToClient(@Valid @PathVariable Long clientId, @Valid @PathVariable Long policyId) {
        if (clientId == null || policyId == null) {
            return ResponseEntity.ok(new Status(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Problem occurred"));
        }
        return cs.issuePolicy(clientId, policyId);
    }
}
