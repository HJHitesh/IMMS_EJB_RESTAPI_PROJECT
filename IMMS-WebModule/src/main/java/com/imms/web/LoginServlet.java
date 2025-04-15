package com.imms.web;

import java.io.IOException;

import com.imms.ejb.UserServiceBean;
import com.imms.model.User;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @EJB private UserServiceBean userService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.authenticate(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("dashboard.jsp");
        } else {
            resp.sendRedirect("login.jsp?error=true");
        }
    }
}
