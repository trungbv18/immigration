package com.example.immigration.controller;

import com.example.immigration.model.Customer;
import com.example.immigration.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(value = "*", maxAge = 3600)
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/customerId/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        if(customerService.getCustomerById(id).isPresent()){
            Customer customer = customerService.getCustomerById(id).get();
            return ResponseEntity.ok(customer);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/customerId/{id}")
    public ResponseEntity<Customer> updateCustomerById( @RequestBody Customer customerUpdate
                                                        ,@PathVariable("id") Long id)
    {
        if(customerService.getCustomerById(id).isPresent()){
            customerService.updateCustomer(customerUpdate,id);
            return ResponseEntity.ok( customerService.updateCustomer(customerUpdate,id));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/customerId/{id}")
    public Object deleteCustomerById(@PathVariable("id") Long id){
        if(customerService.getCustomerById(id).isPresent()){
            customerService.deleteCustomerById(id);
            return ResponseEntity.ok("Deleted Customer with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/last-id")
    public ResponseEntity<Long> getLastId(){
        Long id = customerService.getLastId();
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}
