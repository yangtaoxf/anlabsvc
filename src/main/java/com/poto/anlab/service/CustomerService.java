package com.poto.anlab.service;

import com.poto.anlab.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void add(Customer entity);

    void delete(int id);

    void update(Customer entity);
}
