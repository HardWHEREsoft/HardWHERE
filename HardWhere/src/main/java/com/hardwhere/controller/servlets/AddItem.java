package com.hardwhere.controller.servlets;

/**
 * Created by menaka on 7/11/15.
 */
import com.hardwhere.controller.javaclasses.InsertIntoDB;
import com.hardwhere.controller.javaclasses.MongoDBConnection;
import com.hardwhere.model.Item_POJO;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.print.attribute.standard.PrinterState;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by menaka on 7/9/15.
 */
public class AddItem extends HttpServlet{

    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String item_Name=request.getParameter("item_Name");
        String item_description=request.getParameter("item_description");
        String item_Type=request.getParameter("item_Type");
        String itemModel=request.getParameter("itemModel");
        String itemBrand=request.getParameter("itemBrand");
        String itemSize=request.getParameter("itemSize");
        String itemThickness=request.getParameter("itemThickness");
        String itemPrice=request.getParameter("itemPrice");
        String file=request.getParameter("file");
        String companyID= (String) request.getSession().getAttribute("User");

        Item_POJO item_pojo=new Item_POJO();
        item_pojo.setItem_Type(item_Type);
        item_pojo.setItem_Brand(itemBrand);
        item_pojo.setItem_Description(item_description);
        item_pojo.setItem_ID(String.valueOf(System.nanoTime()));
        item_pojo.setItem_Image(file);
        item_pojo.setItem_Model(itemModel);
        item_pojo.setItem_Name(item_Name);
        item_pojo.setItem_Price(itemPrice);
        item_pojo.setItem_Size(itemSize);
        item_pojo.setItem_Thickness(itemThickness);
        item_pojo.setCompany_id(companyID);

        ObjectMapper mapper = new ObjectMapper();
        String item=mapper.writeValueAsString(item_pojo);
        DBObject itemObject = (DBObject) JSON.parse(item);

        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection col=mongoDatabase.getCollection("items");
        DBCollection testCol=mongoDatabase.getCollection("test");
        col.insert(itemObject);

        boolean collectionExists = mongoDatabase.collectionExists("test");

        if(collectionExists){
            addItemToTree(testCol,item_pojo);
        }else{
            initiateTree(testCol,item_pojo);
        }



        try {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            String message = "Item added successfully";
            request.setAttribute("Result", message);
//            rd.include(request, response);
            rd.forward(request, response);
//            PrintWriter out = response.getWriter();
//            out.print(mdbc.show());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


        //mdbc.show();
    }


    public void fileUplod(HttpServletRequest req){


        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + DATA_DIRECTORY;

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    // saves the file to upload directory
                    item.write(uploadedFile);
                }
            }


        } catch (FileUploadException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public void initiateTree(DBCollection testCol,Item_POJO item_pojo){

        BasicDBObject test = new BasicDBObject("_id", item_pojo.getItem_Thickness());
        BasicDBList list=new BasicDBList();
        //create itemId list
        BasicDBList ItemIdList=new BasicDBList();
        ItemIdList.add(item_pojo.getItem_ID());
        //create item object for add tree
        BasicDBObject itemAdd=new BasicDBObject();
        itemAdd.put("value", "Item_ID");
        itemAdd.put("Ids",ItemIdList);
        list.add(itemAdd);
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", "Thickness");
        list=new BasicDBList();
        //create itemId list
        ItemIdList=new BasicDBList();
        ItemIdList.add(item_pojo.getItem_ID());
        //create item object for add tree
        itemAdd=new BasicDBObject();
        itemAdd.put("value", item_pojo.getItem_Thickness());
        itemAdd.put("Ids",ItemIdList);
        list.add(itemAdd);
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", item_pojo.getItem_Size());
        list=new BasicDBList();
        list.add("Thickness");
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", "Size");
        list=new BasicDBList();
        //create itemId list
        ItemIdList=new BasicDBList();
        ItemIdList.add(item_pojo.getItem_ID() );
        //create item object for add tree
        itemAdd=new BasicDBObject();
        itemAdd.put("value", item_pojo.getItem_Size());
        itemAdd.put("Ids",ItemIdList);
        list.add(itemAdd);
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", item_pojo.getItem_Brand());
        list=new BasicDBList();
        list.add("Size");
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", "Brand");
        list=new BasicDBList();
        //create itemId list
        ItemIdList=new BasicDBList();
        ItemIdList.add(item_pojo.getItem_ID() );
        //create item object for add tree
        itemAdd=new BasicDBObject();
        itemAdd.put("value", item_pojo.getItem_Brand());
        itemAdd.put("Ids",ItemIdList);
        list.add(itemAdd);
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", item_pojo.getItem_Model());
        list=new BasicDBList();
        list.add("Brand");
        test.put("children",list);
        testCol.insert(test);

        test = new BasicDBObject("_id", item_pojo.getItem_Type());
        list=new BasicDBList();
        //create itemId list
        ItemIdList=new BasicDBList();
        ItemIdList.add(item_pojo.getItem_ID());
        //create item object for add tree
        itemAdd=new BasicDBObject();
        itemAdd.put("value", item_pojo.getItem_Model());
        itemAdd.put("Ids",ItemIdList);
        list.add(itemAdd);
        test.put("children",list);
        testCol.insert(test);
    }

    public void addItemToTree(DBCollection testCol,Item_POJO item_pojo){

        if(item_pojo.getItem_Type().equals("Material")){
            if(item_pojo.getItem_Model().equals("Tile")){
                //Item Model add
                BasicDBObject query = new BasicDBObject();
                query.put("_id", "Material");
                DBObject dbObj = testCol.findOne(query);
                AddItemId(testCol,dbObj,item_pojo.getItem_Model(),item_pojo.getItem_ID());
                //Brand add
                query = new BasicDBObject();
                query.put("_id", "Brand");
                dbObj = testCol.findOne(query);
                BasicDBList Brand_children= (BasicDBList) dbObj.get("children");
                //Check Item brand
                if(!isHere(Brand_children,item_pojo.getItem_Brand())){

                    BasicDBObject itemAdd=new BasicDBObject();
                    //create itemId list
                    BasicDBList ItemIdList=new BasicDBList();
                    ItemIdList.add(item_pojo.getItem_ID());
                    //create item object for add tree
                    itemAdd=new BasicDBObject();
                    itemAdd.put("value", item_pojo.getItem_Brand());
                    itemAdd.put("Ids",ItemIdList);
                    Brand_children.add(itemAdd);

                    System.out.println(Brand_children);
                    testCol.save(dbObj);

                    //new Brand Updated
                    BasicDBObject test = new BasicDBObject("_id", item_pojo.getItem_Brand());
                    BasicDBList list=new BasicDBList();
                    list.add("Size");
                    test.put("children",list);
                    testCol.insert(test);

                }else{
                    AddItemId(testCol,dbObj,item_pojo.getItem_Brand(),item_pojo.getItem_ID());
                }
                //Size add

                query = new BasicDBObject();
                query.put("_id", "Size");
                dbObj = testCol.findOne(query);
                BasicDBList Size_children= (BasicDBList) dbObj.get("children");
                if(!isHere(Size_children,item_pojo.getItem_Size())){

                    BasicDBObject itemAdd=new BasicDBObject();
                    //create itemId list
                    BasicDBList ItemIdList=new BasicDBList();
                    ItemIdList.add(item_pojo.getItem_ID());
                    //create item object for add tree
                    itemAdd.put("value", item_pojo.getItem_Size());
                    itemAdd.put("Ids",ItemIdList);

                    Size_children.add(itemAdd);
                    System.out.println(Size_children);
                    testCol.save(dbObj);

                    //new Size Updated
                    BasicDBObject test = new BasicDBObject("_id", item_pojo.getItem_Size());
                    BasicDBList list=new BasicDBList();
                    list.add("Thickness");
                    test.put("children",list);
                    testCol.insert(test);

                }else{

                    AddItemId(testCol,dbObj,item_pojo.getItem_Size(),item_pojo.getItem_ID());

                }
                //Thickness add
                query = new BasicDBObject();
                query.put("_id", "Thickness");
                dbObj = testCol.findOne(query);
                BasicDBList Thickness_children= (BasicDBList) dbObj.get("children");
                if(!isHere(Thickness_children,item_pojo.getItem_Thickness())){

                    BasicDBObject itemAdd=new BasicDBObject();
                    //create itemId list
                    BasicDBList ItemIdList=new BasicDBList();
                    ItemIdList.add(item_pojo.getItem_ID());
                    //create item object for add tree
                    itemAdd.put("value", item_pojo.getItem_Thickness());
                    itemAdd.put("Ids",ItemIdList);

                    Thickness_children.add(itemAdd);

                    testCol.save(dbObj);

                    BasicDBObject test = new BasicDBObject("_id", item_pojo.getItem_Thickness());
                    BasicDBList list=new BasicDBList();
                    //create itemId list
                    ItemIdList=new BasicDBList();
                    ItemIdList.add(item_pojo.getItem_ID());
                    //create item object for add tree
                    itemAdd=new BasicDBObject();
                    itemAdd.put("value", "Item_ID");
                    itemAdd.put("Ids",ItemIdList);
                    list.add(itemAdd);
                    test.put("children",list);
                    testCol.insert(test);

                }else{

                    query = new BasicDBObject();
                    query.put("_id", item_pojo.getItem_Thickness());
                    dbObj = testCol.findOne(query);

                    AddItemId(testCol,dbObj, "Item_ID", item_pojo.getItem_ID());

                }
            }
        }
    }
    public boolean isHere(BasicDBList list,String item){

        for(Object obj:list){
            BasicDBObject NewObj= (BasicDBObject) obj;
            if(NewObj.get("value").equals(item)){
                return true;
            }
        }
        return false;

    }
    public void AddItemId(DBCollection testCol,DBObject dbObj,String item,String itemID){
        BasicDBList list= (BasicDBList) dbObj.get("children");
        for(Object obj:list){
            BasicDBObject NewObj= (BasicDBObject) obj;
            if(NewObj.get("value").equals(item)){
                BasicDBList Ids= (BasicDBList) NewObj.get("Ids");
                Ids.add(itemID );
            }
        }
        testCol.save(dbObj);
    }

}