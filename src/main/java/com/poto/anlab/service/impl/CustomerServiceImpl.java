package com.poto.anlab.service.impl;

import com.poto.anlab.mapper.CustomerMapper;
import com.poto.anlab.model.Customer;
import com.poto.anlab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public  List<Customer> getAllCustomers(){
        return customerMapper.getAllCustomers();
    }
    @Override
    public void add(Customer entity){
        customerMapper.add(entity);
    }
    @Override
    public void delete(int id){
        customerMapper.delete(id);
    }
    @Override
    public  void update(Customer entity){
        customerMapper.update(entity);
    }

}
