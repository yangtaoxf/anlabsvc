package com.poto.anlab.service;

import com.poto.anlab.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> getAll();

    void add(Manufacturer entity);

    void delete(int id);

    void update(Manufacturer entity);
}
