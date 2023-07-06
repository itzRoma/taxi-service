package com.itzroma.mate.taxiservice.controller.car;

import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.model.Car;
import com.itzroma.mate.taxiservice.model.Manufacturer;
import com.itzroma.mate.taxiservice.service.CarService;
import com.itzroma.mate.taxiservice.service.ManufacturerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCarController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.itzroma.mate.taxiservice");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/cars/add.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String model = req.getParameter("model");
        long manufacturerId = Long.parseLong(req.getParameter("manufacturer_id"));
        Manufacturer manufacturer = manufacturerService.get(manufacturerId);
        Car car = new Car(model, manufacturer);
        carService.create(car);
        resp.sendRedirect(req.getContextPath() + "/cars/add");
    }
}
