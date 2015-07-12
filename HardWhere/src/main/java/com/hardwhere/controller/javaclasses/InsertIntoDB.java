package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Companies;
import com.hardwhere.model.Item_POJO;
import com.mongodb.DBObject;
import org.mongodb.morphia.mapping.Mapper;

/**
 * Created by menaka on 7/11/15.
 */
public class InsertIntoDB{

    private Item_POJO item;
    private Companies company;

    public InsertIntoDB(Item_POJO item){

        this.item = item;
    }

    public InsertIntoDB(Companies cm){
        this.company = cm;
    }

    public DBObject toDBObject(String clas){
        Mapper map = new Mapper();
        if(clas.equals("itemPojo"))
            return map.toDBObject(this.item);
        else
            return map.toDBObject(this.company);
    }

}