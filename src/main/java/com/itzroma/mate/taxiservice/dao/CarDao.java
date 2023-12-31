package com.itzroma.mate.taxiservice.dao;

import com.itzroma.mate.taxiservice.model.Car;
import java.util.List;

public interface CarDao extends GenericDao<Car> {
    List<Car> getAllByDriver(Long driverId);
}
