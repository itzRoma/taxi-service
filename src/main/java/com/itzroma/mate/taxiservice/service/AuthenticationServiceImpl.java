package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.exception.AuthenticationException;
import com.itzroma.mate.taxiservice.lib.Inject;
import com.itzroma.mate.taxiservice.lib.Service;
import com.itzroma.mate.taxiservice.model.Driver;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverService driverService;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driver = driverService.findByLogin(login);
        if (driver.isEmpty() || !driver.get().getPassword().equals(password)) {
            throw new AuthenticationException("Invalid login or password");
        }
        return driver.get();
    }
}
