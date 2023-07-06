package com.itzroma.mate.taxiservice.controller;

import com.itzroma.mate.taxiservice.exception.AuthenticationException;
import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.model.Driver;
import com.itzroma.mate.taxiservice.service.AuthenticationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.itzroma.mate.taxiservice");

    private final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Driver driver = authenticationService.login(login, password);
            req.getSession().setAttribute("driverId", driver.getId());
            resp.sendRedirect(req.getContextPath() + "/index");
        } catch (AuthenticationException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
