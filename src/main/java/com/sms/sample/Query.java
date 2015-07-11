package com.sms.sample;

import com.mongodb.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Ehelepola on 09/07/2015.
 */
@WebServlet(name = "Query")
public class Query  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("search"));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public ArrayList<Items> getItemsByrPrice(String ItemName) throws UnknownHostException {

        ArrayList<Items> reList=new ArrayList<>();
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //Connect to database
        DB db = mongo.getDB("HardWHERE");

        //Update Database
        DBCollection collection = db.getCollection("items");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("name", ItemName);
        DBCursor cursor = collection.find(whereQuery);
        cursor.sort(new BasicDBObject("price ", -1));
        while(cursor.hasNext()){

            BasicDBObject document= (BasicDBObject) cursor.next();

            String name=document.getString("name");
            String description=document.getString("description");
            String image=document.getString("image");
            String shopName=document.getString("shopName");
            String price=document.getString("price");
            String contact=document.getString("contact");
            String district=document.getString("district");

            Items items= new Items();
            items.setName(name);
            items.setContact(contact);
            items.setDescription(description);
            items.setDistrict(district);
            items.setImage(image);
            items.setPrice(price);
            items.setShopName(shopName);
            reList.add(items);
        }

        return reList;
    }

}
