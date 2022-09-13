package com.example.immigration.service;

import com.example.immigration.model.Customer;
import com.example.immigration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customerUpdate, Long customerId){
        customerUpdate.setId(customerId);
        customerRepository.save(customerUpdate);
        return customerUpdate;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Long getLastId() {
        return customerRepository.selectLastId();
    }
}
