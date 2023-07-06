package com.itzroma.mate.taxiservice.controller.manufacturer;

import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.model.Manufacturer;
import com.itzroma.mate.taxiservice.service.ManufacturerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.itzroma.mate.taxiservice");
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/manufacturers/add.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        Manufacturer manufacturer = new Manufacturer(name, country);
        manufacturerService.create(manufacturer);
        resp.sendRedirect(req.getContextPath() + "/manufacturers/add");
    }
}
