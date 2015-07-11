package com.hardwhere.controller.javaclasses;

import com.hardwhere.model.Item_POJO;

import java.util.ArrayList;

/**
 * Created by menaka on 7/11/15.
 */
public class MyItems {

    private long user_id;

    public MyItems(long id){
        this.user_id = id;
    }



    public ArrayList<Item_POJO> getServices(){
        ArrayList<Item_POJO> services = new ArrayList<Item_POJO>();
        return services;
    }

    public ArrayList<Item_POJO> getMaterials(){
        ArrayList<Item_POJO> materials = new ArrayList<Item_POJO>();
        return materials;
    }

    public ArrayList<Item_POJO> getEquipments(){
        ArrayList<Item_POJO> equipments = new ArrayList<Item_POJO>();
        return equipments;
    }
}
