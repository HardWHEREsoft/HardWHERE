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

    private MongoClient client;
    private DB mongoDatabase;
    private DBObject record;

    public MongoDBConnection(DBObject record){
        this.record = record;

    }

    public void createConnection(){
        try{
            // To connect to mongodb server
            this.client = new MongoClient( "localhost" , 27017 );
            // Now connect to your databases
            this.mongoDatabase = client.getDB("HardWHERE");
            this.mongoDatabase.getCollection("items");
            System.out.println("Connect to database successfully");
            this.addItemtoDatabase();
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void addItemtoDatabase(){
        DBCollection col = this.mongoDatabase.getCollection("items");
        col.insert(this.record);
    }

    public String show(){
        String s = "";
        DBCollection col = this.mongoDatabase.getCollection("items");
        Item_POJO pojo = new Item_POJO();
        DBCursor cursor = col.find();
        int i=1;
        while (cursor.hasNext()) {
           s = s+"Inserted Document: "+i+"\n"+cursor.next();
            System.out.println();
//            DBObject obj = cursor.next();
//            Mapper map = new Mapper();
            System.out.println(pojo.getItem_Name());
            i++;
        }
        return s;
    }

}