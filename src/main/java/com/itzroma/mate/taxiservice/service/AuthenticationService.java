package com.itzroma.mate.taxiservice.service;

import com.itzroma.mate.taxiservice.exception.AuthenticationException;
import com.itzroma.mate.taxiservice.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
