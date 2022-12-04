package vttp2022.paf.day21workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.paf.day21workshop.models.Customer;
import vttp2022.paf.day21workshop.repositories.CustomerRepository;

@RestController
@RequestMapping(path = "/api/customers", produces=MediaType.APPLICATION_JSON_VALUE )
public class CustomerRESTController {
    

    @Autowired
    private CustomerRepository cusRepo;

    @GetMapping()
    public ResponseEntity<String> getAllCustomer(@RequestParam(required = false) String limit, 
            @RequestParam(required = false) String offset ){

            // query the database for the customer 
            List<Customer> customers = 

            }

    
}
