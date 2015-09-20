package com.hardwhere.controller.servlets;

import com.hardwhere.model.Companies;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by menaka on 9/20/15.
 */
public class Company_Reg extends HttpServlet{

    private Companies company;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        this.company = new Companies();

        //Setting all the parameters
        this.company.setShop_name(request.getParameter("name"));
        this.company.setType(request.getParameter("type"));
        this.company.setTelephone(request.getParameter("tel"));
        this.company.setEmail(request.getParameter("email"));
        this.company.setAddress1(request.getParameter("address1"));
        this.company.setAddress2(request.getParameter("address2"));
        this.company.setAddress3(request.getParameter("address3"));

        this.addCompany(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCompany(HttpServletRequest request){

        BasicDBObject company = new BasicDBObject();
        company.append("name", this.company.getShop_name())
                .append("type", this.company.getType())
                .append("tel", this.company.getTelephone())
                .append("email", this.company.getEmail())
                .append("address1", this.company.getAddress1())
                .append("address2", this.company.getAddress2())
                .append("address3", this.company.getAddress3())
                .append("owner", request.getSession().getAttribute("customer"));

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection col=mongoDatabase.getCollection("companies");
        col.insert(company);
    }


}
