package com.tms.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(value = "/car")
public class CarServlet extends HttpServlet {

    private Map<String, Car> cars;

    @Override
    public void init() throws ServletException {
        cars = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        PrintWriter writer = resp.getWriter();

        if (id.equals("")){
            writer.println(cars);
        }else{
            writer.println(cars.get(id));
        }
        GregorianCalendar gcalendar = new GregorianCalendar();
        String time = gcalendar.get(Calendar.HOUR) + ":"
                + gcalendar.get(Calendar.MINUTE) + ":"
                + gcalendar.get(Calendar.SECOND);
        Cookie cookie = new Cookie("time", time);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Car car = new Car(name);
        cars.put(id, car);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        cars.remove(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        cars.get(id).setName(name);
    }
}
