package com.itzroma.mate.taxiservice.controller.car;

import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.service.CarService;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.itzroma.mate.taxiservice");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        carService.delete(Long.parseLong(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
