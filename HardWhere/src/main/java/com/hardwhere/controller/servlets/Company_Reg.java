package com.hardwhere.controller.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menaka on 9/20/15.
 */
public class Company_Reg extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){


        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
