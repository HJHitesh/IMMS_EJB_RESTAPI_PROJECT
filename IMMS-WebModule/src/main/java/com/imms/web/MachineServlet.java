package com.imms.web;

import java.io.IOException;
import java.io.PrintWriter;

import com.imms.ejb.MachineService;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MachineServlet extends HttpServlet {
	
    @EJB
    private MachineService machineService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String status = machineService.getMachineStatus(1);
        out.println("<h1>" + status + "</h1>");
    }
}
