package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Item_POJO;
import com.mongodb.DBObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.mongodb.morphia.mapping.Mapper;

/**
 * Created by menaka on 7/11/15.
 */
public class InsertIntoDB{

    private Item_POJO item;

    public InsertIntoDB(Item_POJO item){

        this.item = item;
    }

    public String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(item);

        }catch(Exception e){
            return "Error";
        }
    }

    public DBObject toDBObject(){
        Mapper map = new Mapper();
        return map.toDBObject(this.item);
    }

}