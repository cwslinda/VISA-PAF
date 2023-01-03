package vttp2022.paf.day21workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonArray;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp2022.paf.day21workshop.models.Customer;
import vttp2022.paf.day21workshop.models.Order;
import vttp2022.paf.day21workshop.repositories.CustomerRepository;

@RestController
@RequestMapping(path = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE )
public class CustomerRESTController {
    

    @Autowired
    private CustomerRepository cusRepo;

    // when doing the query in postman, remember to include the value for offset and limit
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

            @GetMapping(path = "{id}", produces=MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<String> getCustomerId(@PathVariable("id") String id){
                System.out.println("customer id > " + id);

                Customer c = cusRepo.getCustomerById(id);

                if(c == null){
                    System.out.println("unable to find customer with the given id" + id);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("No orders for customer id %s", id));

                }

               JsonObject result = c.toJson();

               return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(result.toString());

            }

            @GetMapping(path = "{id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<String> getCustomerOrdersById(@PathVariable("id") String id){

                List<Order> orders = cusRepo.getCustomerOrdersById(id);

                if(orders.size() == 0){
                    System.out.println("no orders for the given id" + id);
                    return ResponseEntity.status(HttpStatus.OK).body(String.format("No orders for customer id %s", id));

                } 
                
                JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
                for(Order o : orders){
                    arrBuilder.add(o.toJSON());
                }
                
                JsonArray result = arrBuilder.build();

                return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(result.toString());
            }

    
}
