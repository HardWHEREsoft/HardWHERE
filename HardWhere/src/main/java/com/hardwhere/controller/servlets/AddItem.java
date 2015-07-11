package com.hardwhere.controller.servlets;

/**
 * Created by menaka on 7/11/15.
 */
import com.hardwhere.controller.javaclasses.InsertIntoDB;
import com.hardwhere.controller.javaclasses.MongoDBConnection;
import com.hardwhere.model.Item_POJO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by menaka on 7/9/15.
 */
public class AddItem extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        Item_POJO item = new Item_POJO();
        item.setItem_ID(System.nanoTime());
        item.setUser(request.getRemoteUser());
        item.setItem_Name(request.getParameter("item_Name"));
        item.setItem_Description(request.getParameter("item_description"));
        item.setItem_Price(request.getParameter("item_price"));
        item.setItem_Image(request.getParameter("item_image"));
        item.setItem_Type(request.getParameter("item_Type"));

        InsertIntoDB iidb = new InsertIntoDB(item);
        System.out.println(iidb.toDBObject());
        MongoDBConnection mdbc = new MongoDBConnection(iidb.toJson());
        mdbc.createConnection();
        System.out.println(mdbc.show());
        try {
            RequestDispatcher rd = request.getRequestDispatcher("additem.jsp");
            String message = "Item added successfully";
            request.setAttribute("Result", message);
            rd.include(request, response);
            rd.forward(request, response);
//            PrintWriter out = response.getWriter();
//            out.print(mdbc.show());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


//        mdbc.show();
    }

}