package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.model.Car;
import com.itzroma.mate.taxiservice.model.Driver;
import java.util.List;

public interface CarService extends GenericService<Car> {
    void addDriverToCar(Driver driver, Car car);

    void removeDriverFromCar(Driver driver, Car car);

    List<Car> getAllByDriver(Long driverId);
}
