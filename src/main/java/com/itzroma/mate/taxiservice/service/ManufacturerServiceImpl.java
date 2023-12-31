package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.dao.ManufacturerDao;
import com.itzroma.mate.taxiservice.lib.Inject;
import com.itzroma.mate.taxiservice.lib.Service;
import com.itzroma.mate.taxiservice.model.Manufacturer;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id).orElseThrow(() ->
            new NoSuchElementException("Can't get manufacturer by id: " + id)
        );
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}
