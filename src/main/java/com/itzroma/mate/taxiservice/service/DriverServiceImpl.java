package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.dao.DriverDao;
import com.itzroma.mate.taxiservice.exception.LoginUnavailableException;
import com.itzroma.mate.taxiservice.lib.Inject;
import com.itzroma.mate.taxiservice.lib.Service;
import com.itzroma.mate.taxiservice.model.Driver;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        if (driverDao.findByLogin(driver.getLogin()).isPresent()) {
            throw new LoginUnavailableException("Login is unavailable");
        }
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id).orElseThrow(() ->
            new NoSuchElementException("Can't get driver by id: " + id)
        );
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        return driverDao.findByLogin(login);
    }
}
