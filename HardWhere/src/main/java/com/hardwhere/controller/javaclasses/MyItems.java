package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Item_POJO;
import com.mongodb.*;

import java.util.ArrayList;

/**
 * Created by menaka on 7/11/15.
 */
public class MyItems {

    private long user_id;
    private MongoClient mongoClient;
    private DB mongoDatabase;

    private ArrayList<Item_POJO> items = new ArrayList<Item_POJO>();

    public MyItems(long id){
        this.user_id = id;
        this.dbConnection();
    }



    public MyItems(){
        this.dbConnection();
    }


    public void dbConnection(){
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
        this.allItems();
    }

    public void allItems(){
        BasicDBObject obj;
        ConvertToPOJO cp;
        Item_POJO pojo;
        DBCollection collection = mongoDatabase.getCollection("items");

//        BasicDBObject whereQuery = new BasicDBObject();
//        whereQuery.put("user_id", this.user_id);
//        DBCursor cursor = collection.find(whereQuery);
        DBCursor cursor = collection.find();
        while(cursor.hasNext()){
            obj = (BasicDBObject) cursor.next();
            cp = new ConvertToPOJO(obj);
            pojo = cp.convert();
//            if(pojo.getItem_Type()!=null){
            System.out.println(pojo);
//            }
            this.items.add(pojo);

        }
    }


    public ArrayList<Item_POJO> getItems() {
        return items;
    }

}
