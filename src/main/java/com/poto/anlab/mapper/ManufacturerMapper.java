package com.poto.anlab.mapper;

import com.poto.anlab.model.Manufacturer;

import java.util.List;

public interface ManufacturerMapper {
    List<Manufacturer> getAll();
    void add(Manufacturer entity);
    void delete(int id);
    void update(Manufacturer entity);
}
