package com.example.immigration.service;

import com.example.immigration.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customerUpdate, Long customerId);

    Optional<Customer> getCustomerById(Long id);

    void deleteCustomerById(Long id);

    List<Customer> getAllCustomer();
}
