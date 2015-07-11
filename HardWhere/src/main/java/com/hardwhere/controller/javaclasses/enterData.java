package com.hardwhere.controller.javaclasses;

import com.mongodb.BasicDBObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.*;
import javax.servlet.ServletConfig;


/**
 *
 * @author sachiththra
 */
public class enterData extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public void init(ServletConfig config)
    {
        try {
//            m = new Mongo( "localhost" );

        } catch (MongoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("errorMessage1");
        request.getSession().setAttribute("errorMessage1", "");

        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String district=request.getParameter("district");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        //String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        PrintWriter out = response.getWriter();
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        System.out.println("Connected");
        DB db = mongo.getDB( "HardWHERE" );

        DBCollection coll = db.getCollection("companies");

        DBObject query = new BasicDBObject("username", username);
        DBCursor cursor = coll.find(query);
        //request.setAttribute("errorMessage", "");
        if(cursor.hasNext()){
            request.getSession().setAttribute("errorMessage1", "User name alredy exists");
            response.sendRedirect(request.getHeader("Referer"));
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            request.getSession().setAttribute("errorMessage", "");
            out.println(cursor.next());

        }else{
            //request.getSession().removeAttribute("errorMessage1");
            request.getSession().setAttribute("errorMessage1", "");
            BasicDBObject doc = new BasicDBObject("name", name).
                    append("address", address).
                    append("district", district).
                    append("Tel", tel).
                    append("email", email).
                    append("username", username).
                    append("password", password);
            coll.insert(doc);
        }






        /*DBObject d1 = coll.findOne(query);

        if(d1 == null){
            coll.insert(doc);
            request.getSession().removeAttribute("errorMessage");
        }
        else {
            request.getSession().setAttribute("errorMessage", "Please submit an amount of at least 1");
             response.sendRedirect(request.getHeader("Referer"));
        }*/
        //BasicDBObject career = new BasicDBObject();

        //career.put("goals", 100);
        //career.put("matches", 200);

        //doc.put("career", career);


        //coll.insert(career);

        //out.println("Inserted DBObject "+coll);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}