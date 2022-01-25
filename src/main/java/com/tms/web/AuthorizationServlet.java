package com.tms.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/authorizationPage.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        UserService userService = new UserBase();
        String answer = userService.userAuthorization(name, password);
        if (answer.equals("Administrator")){
            req.getRequestDispatcher("/WEB-INF/pages/userRegistration.html").forward(req, resp);
        }else if(answer.equals("User")){
            req.getRequestDispatcher("/WEB-INF/pages/picturePage.html").forward(req, resp);
        }else if(answer.equals("InvalidPassword")){
            throw new ErrorAddingUserException("Invalid Password");
        }
    }
}
