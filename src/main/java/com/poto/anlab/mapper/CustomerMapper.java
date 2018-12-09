package com.poto.anlab.mapper;

import com.poto.anlab.model.Customer;

import java.util.List;

public interface CustomerMapper {
    List<Customer> getAllCustomers();
    void add(Customer entity);
    void delete(int id);
    void update(Customer entity);
}
