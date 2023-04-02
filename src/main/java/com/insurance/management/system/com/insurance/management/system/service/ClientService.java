package com.insurance.management.system.com.insurance.management.system.service;

import com.insurance.management.system.com.insurance.management.system.dao.AddressRepo;
import com.insurance.management.system.com.insurance.management.system.dao.ClientRepo;
import com.insurance.management.system.com.insurance.management.system.dao.ContactInformationRepo;
import com.insurance.management.system.com.insurance.management.system.dao.InsuranceRepo;
import com.insurance.management.system.com.insurance.management.system.entity.Address;
import com.insurance.management.system.com.insurance.management.system.entity.Client;
import com.insurance.management.system.com.insurance.management.system.entity.ContactInformation;
import com.insurance.management.system.com.insurance.management.system.entity.Insurance;
import com.insurance.management.system.com.insurance.management.system.model.requestModel.AddressAndContactModel;
import com.insurance.management.system.com.insurance.management.system.model.requestModel.ClientModel;
import com.insurance.management.system.com.insurance.management.system.model.responseModel.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    ContactInformationRepo contactInformationRepo;
    @Autowired
    InsuranceRepo insuranceRepo;

    public ResponseEntity<?> saveClientData(ClientModel clientModel) {
        Client c = new Client();
        c.setName(clientModel.getName());
        c.setDob(clientModel.getDob());
        clientRepo.save(c);
        return ResponseEntity.ok(new Status("200","Client data saved"));
    }

    public ResponseEntity<?> fetchAllClientsData() {
        List<Client> allClients = clientRepo.findAll();
        return ResponseEntity.ok(allClients);
    }

    public ResponseEntity<?> fetchClientData(Long id) {
        Client c = clientRepo.findById(id).orElse(null);
        return ResponseEntity.ok(c);
    }

    public ResponseEntity<?> updateClientsData(Long id, AddressAndContactModel a) {
        Client c = clientRepo.findById(id).orElse(null);
        if (c == null) {
            return ResponseEntity.ok(new Status(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Client data is not found!"));
        }
        List<Address> isAvailable = addressRepo.findAll();
        for (Address a1 : isAvailable) {
            if (a1.getClient() != null && a1.getClient().getClientId() == id) {
                addressRepo.delete(a1);
            }
        }
        Address add = new Address();
        add.setCity(a.getCity());
        add.setCountry(a.getCountry());
        add.setState(a.getState());
        add.setDistrict(a.getDistrict());
        add.setStreet(a.getStreet());
        add.setZipCode(a.getZipCode());
        List<ContactInformation> isContactsAvailable = contactInformationRepo.findAll();
        for (ContactInformation ci1 : isContactsAvailable) {
            if (ci1.getClient().getClientId() == id) {
                contactInformationRepo.delete(ci1);
            }
        }
        ContactInformation ci = new ContactInformation();
        ci.setEmail(a.getEmail());
        ci.setPhNo(a.getPhNo());
        ci.setClient(c);
        add.setClient(c);
        Address ad = addressRepo.save(add);
        c.setAddress(ad);
        System.out.println("address is ===> " + add);
        ContactInformation cc = contactInformationRepo.save(ci);
        c.setContactInformation(cc);
        System.out.println("Contact Information is =====> " + ci);
        clientRepo.save(c);

        return ResponseEntity.ok(new Status("200","Client data updated"));
    }

    public ResponseEntity<?> deleteClientData(Long id) {
        List<Address> isAddressAvailable = addressRepo.findAll();
        for (Address a: isAddressAvailable) {
            if (a.getClient().getClientId() == id) {
                addressRepo.delete(a);
            }
        }
        List<ContactInformation> isContactsAvailable = contactInformationRepo.findAll();
        for (ContactInformation c: isContactsAvailable) {
            if (c.getClient().getClientId() == id) {
                contactInformationRepo.delete(c);
            }
        }
        Client c = clientRepo.findById(id).orElse(null);
        if (c == null) {
            return ResponseEntity.ok(new Status(HttpStatus.NOT_FOUND.toString(),"Data not found!"));
        }
        clientRepo.deleteById(id);
        return ResponseEntity.ok(new Status("200","Client data deleted"));
    }

    public ResponseEntity<?> issuePolicy(Long clientId, Long policyId) {
        Client c = clientRepo.findById(clientId).orElse(null);
        Insurance i = insuranceRepo.findById(policyId).orElse(null);
        if (c == null || i == null) {
            return ResponseEntity.ok(new Status(HttpStatus.NO_CONTENT.toString(),"Data not found!"));
        }
        List<Insurance> insurances = insuranceRepo.findAll();
        for (Insurance ins: insurances) {
            if (ins.getClient() != null && ins.getClient().getClientId() == clientId) {
                ins.setClient(null);
            }
        }
        c.setInsurance(i);
        i.setClient(c);
        clientRepo.save(c);
        return ResponseEntity.ok(new Status("200", "Policy issued to client"));
    }
}
