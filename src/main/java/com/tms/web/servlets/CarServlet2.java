package com.tms.web.servlets;
import com.tms.web.dao.CarDao;
import com.tms.web.dao.ServiceCar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/car2")
public class CarServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("nom");
        ServiceCar serviceCar = new CarDao();
        PrintWriter writer = resp.getWriter();
        writer.println(serviceCar.getCar(nom));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String model = req.getParameter("model");
        ServiceCar serviceCar = new CarDao();
        serviceCar.addCar(nom, model);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        ServiceCar serviceCar = new CarDao();
        serviceCar.editСar(id);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        ServiceCar serviceCar = new CarDao();
        serviceCar.delСar(id);
    }
}
