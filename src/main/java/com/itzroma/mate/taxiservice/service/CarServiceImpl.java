package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.dao.CarDao;
import com.itzroma.mate.taxiservice.lib.Inject;
import com.itzroma.mate.taxiservice.lib.Service;
import com.itzroma.mate.taxiservice.model.Car;
import com.itzroma.mate.taxiservice.model.Driver;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        car.getDrivers().add(driver);
        carDao.update(car);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        car.getDrivers().remove(driver);
        carDao.update(car);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        return carDao.get(id).orElseThrow(() ->
            new NoSuchElementException("Can't get car by id: " + id)
        );
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        return carDao.delete(id);
    }
}
