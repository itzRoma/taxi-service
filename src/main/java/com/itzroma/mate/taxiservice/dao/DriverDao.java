package com.itzroma.mate.taxiservice.dao;

import com.itzroma.mate.taxiservice.model.Driver;
import java.util.Optional;

public interface DriverDao extends GenericDao<Driver> {
    Optional<Driver> findByLogin(String login);
}
