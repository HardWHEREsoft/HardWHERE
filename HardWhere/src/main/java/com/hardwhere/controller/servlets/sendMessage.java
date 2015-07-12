//package com.hardwhere.controller.servlets;
//
///**
// * Created by Ehelepola on 11/07/2015.
// */
//
//import com.sms.sample.MoSender;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by Ehelepola on 08/07/2015.
// */
//
//public class sendMessage extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String address=request.getParameter("address");
//        String message=request.getParameter("message");
//        String appID=request.getParameter("applicationID");
//        MoSender sender=new MoSender();
//        sender.SentSms(message,address,appID);
//        System.out.println(message+" "+address+" "+appID);
//        request.getRequestDispatcher("Messages.jsp").forward(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//}
