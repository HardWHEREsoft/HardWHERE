package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Item_POJO;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.mapping.cache.EntityCache;
import org.mongodb.morphia.mapping.cache.EntityCacheStatistics;

/**
 * Created by menaka on 7/11/15.
 */
public class MongoDBConnection {

    private MongoClient mongoClient;
    private DB mongoDatabase;
    private String record;

    public MongoDBConnection(String record){
        this.record = record;

    }

    public MongoDBConnection(){}

    public void createConnection(){
        try{
            // To connect to mongodb server
            this. mongoClient = new MongoClient( "localhost" , 27017 );
            // Now connect to your databases
            this.mongoDatabase = mongoClient.getDB("HardWHERE");
            this.mongoDatabase.getCollection("items");
            System.out.println("Connect to database successfully");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println(show());
    }

    public String show(){
        String s = "";
        DBCollection col = this.mongoDatabase.getCollection("items");
        Item_POJO pojo = new Item_POJO();
        DBCursor cursor = col.find();
        int i=1;
        while (cursor.hasNext()) {
           s = s+" \n Inserted Document: "+i+cursor.next();
            i++;
        }
        return s;
    }

}