package com.hardwhere;

import com.hardwhere.controller.javaclasses.ConvertToPOJO;
import com.hardwhere.controller.javaclasses.MyItems;
import com.hardwhere.model.Item_POJO;
import com.mongodb.*;

import java.util.ArrayList;

/**
 * Created by menaka on 7/11/15.
 */
public class Add {


    public static void main(String args[]) throws Exception{
        ConvertToPOJO cp;
        Item_POJO item;

        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        //Connect to database
        DB db = mongo.getDB("HardWHERE");

        //Update Database
        DBCollection collection = db.getCollection("companies");
        System.out.println("connected to items");

        BasicDBObject whereQuery = new BasicDBObject();
       // whereQuery.put("item_Name", ItemName);
        DBCursor cursor = collection.find();
       // cursor.sort(new BasicDBObject("price ", -1));

        while(cursor.hasNext()){
            BasicDBObject obj = (BasicDBObject) cursor.next();
            System.out.println(obj);
            cp = new ConvertToPOJO(obj);
            item = cp.convert();
            System.out.println(item.getItem_Description() + item.getItem_ID() + item.getItem_Description());
        }





    }

}
