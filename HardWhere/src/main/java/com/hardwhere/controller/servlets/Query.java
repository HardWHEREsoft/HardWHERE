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

        request.getRequestDispatcher("ItemsDetails.jsp").forward(request, response);
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

    public BasicDBList getIdsList(BasicDBList list,String itemModel){
        BasicDBList Ids=null;
        for(Object obj:list){
            BasicDBObject NewObj= (BasicDBObject) obj;
            if(NewObj.get("value").equals(itemModel)){
                Ids= (BasicDBList) NewObj.get("Ids");

            }
        }
        return Ids;
    }
    public BasicDBList intersect(BasicDBList A, BasicDBList B) {
        BasicDBList rtnList=new BasicDBList();
        for(Object obj : A) {
            String dto= (String) obj;

            if(B.contains(dto)) {

                rtnList.add(dto);
            }
        }

        return rtnList;
    }
    public ArrayList<Item_POJO> getItemList(String item_Type,String itemModel,String itemBrand,String itemSize,String itemThickness){

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection testCol=mongoDatabase.getCollection("test");
        DBCollection col=mongoDatabase.getCollection("items");
        //get the first list
        BasicDBObject query = new BasicDBObject();
        query.put("_id", item_Type);
        DBObject dbObj = testCol.findOne(query);
        BasicDBList Model_children= (BasicDBList) dbObj.get("children");
        BasicDBList list1=getIdsList(Model_children,itemModel);
        //get the second list
        query = new BasicDBObject();
        query.put("_id", "Brand");
        dbObj = testCol.findOne(query);
        Model_children= (BasicDBList) dbObj.get("children");
        BasicDBList list2=getIdsList(Model_children,itemBrand);
        //get the Third list
        query = new BasicDBObject();
        query.put("_id", "Size");
        dbObj = testCol.findOne(query);
        Model_children= (BasicDBList) dbObj.get("children");
        BasicDBList list3=getIdsList(Model_children,itemSize);
        //get the fourth list
        query = new BasicDBObject();
        query.put("_id", "Thickness");
        dbObj = testCol.findOne(query);
        Model_children= (BasicDBList) dbObj.get("children");
        BasicDBList list4=getIdsList(Model_children,itemThickness);

        BasicDBList finalList=new BasicDBList();
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list3);
//        System.out.println(list4);

        if(list2!=null && list3!=null && list4!=null){

            BasicDBList listFilled1=intersect(list1, list2);
            finalList=intersect(listFilled1, intersect(list3, list4));
        }else if(list2!=null && list3!=null){
            BasicDBList listFilled1=intersect(list2, list3);
            finalList=intersect(list1, listFilled1);
        }else if(list2!=null && list4!=null){
            finalList=intersect(list1, intersect(list2, list4));
        }else if(list3!=null && list4!=null){
            finalList=intersect(list1, intersect(list4, list3));
        }else if(list2!=null ){
            finalList=intersect(list1, list2);
        }else if(list3!=null ){
            finalList=intersect(list1, list3);
        }else if(list4!=null ){
            finalList=intersect(list1, list4);
        }else{
            finalList=list1;
        }

        ArrayList<Item_POJO> arrayList=new ArrayList<Item_POJO>();

        MongoClient mongo = null;
        try {
            mongo = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //Connect to database
        DB db = mongo.getDB("HardWHERE");

        //Update Database
        DBCollection collection = db.getCollection("items");

        for(Object obj : finalList) {
            String itemId= (String) obj;
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("item_ID", itemId);
            DBCursor cursor = collection.find(whereQuery);
            BasicDBObject items= (BasicDBObject) cursor.next();
            Item_POJO item_pojo=new Item_POJO();
            item_pojo.setCompany_id(items.getString("company_id"));
            item_pojo.setItem_Brand(items.getString("item_Brand"));
            item_pojo.setItem_Description(items.getString("item_Description"));
            item_pojo.setItem_ID(items.getString("item_ID"));
            item_pojo.setItem_Image(items.getString("item_Image"));
            item_pojo.setItem_Model(items.getString("item_Model"));
            item_pojo.setItem_Name(items.getString("item_Name"));
            item_pojo.setItem_Price(items.getString("item_Price"));
            item_pojo.setItem_Size(items.getString("item_Size"));
            item_pojo.setItem_Thickness(items.getString("item_Thickness"));
            item_pojo.setItem_Type(items.getString("item_Type"));
            arrayList.add(item_pojo);
        }
        return arrayList;


    }

}
