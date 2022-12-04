package vttp2022.paf.day21workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonArray;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.paf.day21workshop.models.Customer;
import vttp2022.paf.day21workshop.repositories.CustomerRepository;

@RestController
@RequestMapping(path = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE )
public class CustomerRESTController {
    

    @Autowired
    private CustomerRepository cusRepo;


    // when doing the query on in postman, remember to include the value for offset and limit
    @GetMapping()
    public ResponseEntity<String> getAllCustomer(@RequestParam(defaultValue = "5") String limit, 
            @RequestParam(defaultValue = "0") String offset ){

            // query the database for the customer 
            List<Customer> customers = cusRepo.getAllCustomer(Integer.parseInt(offset), Integer.parseInt(limit));

            JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
            for(Customer c : customers)
                arrBuilder.add(c.toJson());
            JsonArray result = arrBuilder.build();
            System.out.println("" + result.toString());


            return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
            
            
            

            }

    
}
