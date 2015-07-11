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
 * Created by Ehelepola on 08/07/2015.
 */

@WebServlet(name = "UserMessages")
public class UserMessages extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("Messages.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public ArrayList<MessageDetails> getMessages(String shopName) throws UnknownHostException {

        ArrayList<MessageDetails> reList=new ArrayList<>();
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //Connect to database
        DB db = mongo.getDB("consumerGoods");

        //Update Database
        DBCollection collection = db.getCollection("messages");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("shopName", shopName);
        DBCursor cursor = collection.find(whereQuery);

        while(cursor.hasNext()){

            BasicDBObject document= (BasicDBObject) cursor.next();

            BasicDBList list= (BasicDBList) document.get("messages");
            String name=document.getString("name");
            String address=document.getString("address");
            String appId=document.getString("applicationID");
            MessageDetails messageDetails = new MessageDetails();
            messageDetails.setAddress(address);
            messageDetails.setMessageList(list);
            messageDetails.setName(name);
            messageDetails.setAppID(appId);
            reList.add(messageDetails);

        }
        return reList;
    }
}