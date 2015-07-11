package com.hardwhere.controller.javaclasses;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.*;

/**
 * Created by Ehelepola on 05/07/2015.
 */
public class MessagesDB {


    public void UpdateUserCollection(String name,String address,String applicationID,String message,String shopName) throws UnknownHostException {
        System.out.println("in Here");
        MongoClient mongo=new MongoClient("localhost",27017);
        //Connect to database
        System.out.println("in Here too");
        DB db = mongo.getDB("HardWHERE");

        //Update Database
        System.out.println("in");
        DBCollection collection = db.getCollection("Messages");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("address", address);
        DBCursor cursor = collection.find(whereQuery);
        System.out.println(cursor.hasNext());
        if(cursor.hasNext()) {

            BasicDBObject document= (BasicDBObject) cursor.next();

            BasicDBList list= (BasicDBList) document.get("messages");
            //document.remove("messages");
            list.add(message);
            //document.put("messages",list );
            System.out.println(list);
            System.out.println(document);
            //collection.update(document, updateObj);
            collection.save(document);

        }
        else{

            BasicDBObject document = new BasicDBObject();
            document.put("Username", name);
            document.put("shopName", shopName);
            document.put("address", address);
            document.put("applicationID", applicationID);
            //document.put("messages",new BasicDBObject().append("1",message));
            BasicDBList list=new BasicDBList();
            list.add(message);
            document.append("messages",list);
            System.out.println("added");
            collection.insert(document);
        }


    }
}