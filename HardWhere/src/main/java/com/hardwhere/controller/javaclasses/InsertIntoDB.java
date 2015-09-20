package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Companies;
import com.hardwhere.model.Item_POJO;
import com.hardwhere.model.Person;
import com.mongodb.DBObject;
import org.mongodb.morphia.mapping.Mapper;

/**
 * Created by menaka on 7/11/15.
 */
public class InsertIntoDB{

    private Item_POJO item;
    private Person owner;
    private Companies company;

    public InsertIntoDB(Item_POJO item){

        this.item = item;
    }

    public InsertIntoDB(Companies cm){
        this.company = cm;
    }
    public InsertIntoDB(Person person){
        this.owner = person;
    }

    public DBObject toDBObject(String clas){
        Mapper map = new Mapper();
        if(clas.equals("itemPojo"))
            return map.toDBObject(this.item);
        else if(clas.equals("companies"))
            return map.toDBObject(this.company);
        else
            return  map.toDBObject(this.owner);
    }

}