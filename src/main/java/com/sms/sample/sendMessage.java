package com.sms.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ehelepola on 08/07/2015.
 */
@WebServlet(name = "sendMessage")
public class sendMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address=request.getParameter("address");
        String message=request.getParameter("message");
        String appID=request.getParameter("applicationID");
        MoSender sender=new MoSender();
        sender.SentSms(message,address,appID);
        System.out.println(message+" "+address+" "+appID);
        request.getRequestDispatcher("Messages.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
