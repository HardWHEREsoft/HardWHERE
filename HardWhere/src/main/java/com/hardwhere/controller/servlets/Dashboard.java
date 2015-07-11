package com.hardwhere.controller.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menaka on 7/11/15.
 */
public class Dashboard extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dis = req.getRequestDispatcher("dashboard.jsp");
        String s = "Hello this is your dash board";
        req.setAttribute("Message", s);
        dis.forward(req,resp);
    }
}
