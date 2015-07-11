package com.hardwhere;

import com.hardwhere.controller.javaclasses.InsertIntoDB;
import com.hardwhere.model.Item_POJO;

/**
 * Created by menaka on 7/11/15.
 */
public class Add {


    public static void main(String args[]){
        Item_POJO item = new Item_POJO();
        item.setItem_Name("name");
        item.setItem_Description("dsfsdf");
        item.setItem_Image("D:/dfs");

        InsertIntoDB idb = new InsertIntoDB(item);
        System.out.println(idb.toJson());;
    }

}
