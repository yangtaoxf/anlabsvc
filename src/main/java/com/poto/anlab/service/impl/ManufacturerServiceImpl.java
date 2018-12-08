package com.poto.anlab.service.impl;

import com.poto.anlab.mapper.ManufacturerMapper;
import com.poto.anlab.model.Manufacturer;
import com.poto.anlab.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @Override
    public List<Manufacturer> getAll(){
       return manufacturerMapper.getAll();
    }
    @Override
    public void add(Manufacturer entity){
        manufacturerMapper.add(entity);
    }
    @Override
    public void delete(int id){
        manufacturerMapper.delete(id);
    }
    @Override
    public void update(Manufacturer entity){
        manufacturerMapper.update(entity);
    }

}
