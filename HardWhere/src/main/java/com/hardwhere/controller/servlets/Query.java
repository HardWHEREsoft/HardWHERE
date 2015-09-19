package com.hardwhere.controller.servlets;

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
 * Created by Ehelepola on 09/07/2015.
 */

public class Query  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public ArrayList<Item_POJO> getItemsByrPrice(String ItemName) throws UnknownHostException {

        ArrayList<Item_POJO> reList=new ArrayList<Item_POJO>();
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //Connect to database
        DB db = mongo.getDB("HardWHERE");

        //Update Database
        DBCollection collection = db.getCollection("items");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("item_Name", ItemName);
        DBCursor cursor = collection.find(whereQuery);
        cursor.sort(new BasicDBObject("price ", -1));
        while(cursor.hasNext()){

            BasicDBObject document= (BasicDBObject) cursor.next();

            String user=document.getString("user");
            String description=document.getString("item_Description");
            String image=document.getString("item_Image");
            String item_ID=document.getString("item_ID");
            String price=document.getString("item_Price");
            String item_Type=document.getString("item_Type");
            String item_Name=document.getString("item_Name");


            Item_POJO items= new Item_POJO();
            items.setItem_Description(description);
            items.setItem_ID(item_ID);
            items.setItem_Image(image);
            items.setItem_Name(item_Name);
            items.setItem_Price(price);
            items.setItem_Type(item_Type);
            items.setUser(user);
            reList.add(items);
        }

        return reList;
    }

}
