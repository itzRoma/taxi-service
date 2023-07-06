package com.itzroma.mate.taxiservice.controller.manufacturer;

import com.itzroma.mate.taxiservice.lib.Injector;
import com.itzroma.mate.taxiservice.service.ManufacturerService;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/manufacturers/delete")
public class DeleteManufacturerController extends HttpServlet {
    private static final Injector injector =
            Injector.getInstance("com.itzroma.mate.taxiservice");

    private final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        manufacturerService.delete(id);
        resp.sendRedirect(req.getContextPath() + "/manufacturers");
    }
}
