package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Item_POJO;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.mapping.cache.EntityCache;
import org.mongodb.morphia.mapping.cache.EntityCacheStatistics;

import java.net.UnknownHostException;

/**
 * Created by menaka on 7/11/15.
 */
public class MongoDBConnection {



    private String record;

    public MongoDBConnection(String record){
        this.record = record;

    }

    public MongoDBConnection(){}

    public void createConnection(String name){
        try{
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            // Now connect to your databases
            DB mongoDatabase = mongoClient.getDB("HardWHERE");
            mongoDatabase.getCollection(name);
            System.out.println("Connect to database successfully"+" "+name);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        //System.out.println(show());
    }

    public void insertin(BasicDBObject obj){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // Now connect to your databases
        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection col=mongoDatabase.getCollection("items");

        col.insert(obj);
    }

    public String show()  {
        String s = "";
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // Now connect to your databases
        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection col=mongoDatabase.getCollection("items");
        Item_POJO pojo = new Item_POJO();
        DBCursor cursor = col.find();
        int i=1;
        while (cursor.hasNext()) {
           s = s+" \n Inserted Document: "+i+cursor.next();
            i++;
        }
        return s;
    }

    public boolean check(String username){

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // Now connect to your databases
        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection coll = mongoDatabase.getCollection("companies");

        DBObject query = new BasicDBObject("username", username);
        DBCursor cursor = coll.find(query);


        if(cursor.hasNext()){
            return false;

        }else{
            return true;
        }


    }

}