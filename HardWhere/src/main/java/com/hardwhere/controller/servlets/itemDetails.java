package com.hardwhere.controller.servlets;

import com.hardwhere.model.Companies;
import com.hardwhere.model.Item_POJO;
import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Ehelepola on 12/07/2015.
 */
public class itemDetails  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("itemDetails.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public Companies getItemsByrPrice(String company_id) throws UnknownHostException {


        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //Connect to database
        DB db = mongo.getDB("HardWHERE");

        //Update Database
        DBCollection collection = db.getCollection("companies");

        BasicDBObject whereQuery = new BasicDBObject();

        whereQuery.put("company_id", company_id);
        DBCursor cursor = collection.find(whereQuery);
        BasicDBObject document= (BasicDBObject) cursor.next();

        String name=document.getString("name");
        String tel=document.getString("tel");
        String address3=document.getString("address3");


        Companies companies=new Companies();
        companies.setAddress3(address3);
        companies.setShop_name(name);
        companies.setTelephone(tel);


        return companies;
    }
}
