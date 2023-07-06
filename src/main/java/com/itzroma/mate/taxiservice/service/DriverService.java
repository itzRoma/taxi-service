package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.model.Driver;
import java.util.Optional;

public interface DriverService extends GenericService<Driver> {
    Optional<Driver> findByLogin(String login);
}
