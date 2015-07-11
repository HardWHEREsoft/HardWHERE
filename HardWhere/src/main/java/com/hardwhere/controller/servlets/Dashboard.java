package com.hardwhere.controller.servlets;

import com.hardwhere.controller.javaclasses.MyItems;
import com.hardwhere.model.Item_POJO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by menaka on 7/11/15.
 */
public class Dashboard extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dis = req.getRequestDispatcher("dashboard.jsp");
        String s = "Hello this is your dash board";
//        MyItems items = new MyItems((Long)req.getAttribute("user_id"));

        req.setAttribute("items", process());
        dis.forward(req,resp);
    }

    public ArrayList<Item_POJO> process(){
        MyItems items = new MyItems();
        ArrayList<Item_POJO> itemList = items.getItems();
        return itemList;
    }
}
