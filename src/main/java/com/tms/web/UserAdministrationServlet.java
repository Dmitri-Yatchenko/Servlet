package com.tms.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.String;

@WebServlet("/administration")
public class UserAdministrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/userRegistration.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String male = "";
        String administrator = "";
        if(req.getParameter("male") != null) {
            male = req.getParameter("male");
        }
        String description = req.getParameter("description");
        if(req.getParameter("administrator") != null) {
           administrator = req.getParameter("administrator");
        }
        UserService userService = new UserBase();
        userService.saveUser(name, password, male, description, administrator);
    }
}
