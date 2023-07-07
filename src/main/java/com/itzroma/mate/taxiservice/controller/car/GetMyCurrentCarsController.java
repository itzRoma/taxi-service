package com.itzroma.mate.taxiservice.controller.car;

import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.model.Car;
import com.itzroma.mate.taxiservice.service.CarService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cars/my")
public class GetMyCurrentCarsController extends HttpServlet {
    private static final Injector injector =
            Injector.getInstance("com.itzroma.mate.taxiservice");

    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long driverId = (Long) req.getSession().getAttribute("driverId");
        List<Car> myCars = carService.getAllByDriver(driverId);
        req.setAttribute("cars", myCars);
        req.getRequestDispatcher("/WEB-INF/views/cars/all.jsp").forward(req, resp);
    }
}
