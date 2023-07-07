package com.itzroma.mate.taxiservice.controller.car;

import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.model.Car;
import com.itzroma.mate.taxiservice.model.Driver;
import com.itzroma.mate.taxiservice.service.CarService;
import com.itzroma.mate.taxiservice.service.DriverService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cars/drivers/add")
public class AddDriverToCarController extends HttpServlet {
    private static final Injector injector =
            Injector.getInstance("com.itzroma.mate.taxiservice");

    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Car> cars = carService.getAll();
        List<Driver> drivers = driverService.getAll();
        req.setAttribute("cars", cars);
        req.setAttribute("drivers", drivers);
        req.getRequestDispatcher("/WEB-INF/views/cars/drivers/add.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long carId = Long.parseLong(req.getParameter("car_id"));
        Long driverId = Long.parseLong(req.getParameter("driver_id"));
        Car car = carService.get(carId);
        Driver driver = driverService.get(driverId);

        if (car.getDrivers().contains(driver)) {
            req.setAttribute("errorMessage", "That driver is already set for that car");
            doGet(req, resp);
            return;
        }

        carService.addDriverToCar(driver, car);
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
