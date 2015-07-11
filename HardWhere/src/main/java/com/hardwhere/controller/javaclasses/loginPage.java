package com.hardwhere.controller.javaclasses;

import com.mongodb.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sachiththra
 */
public class loginPage extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public void init(ServletConfig config)
    {
        try {

        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.getSession().removeAttribute("errorMessage");
        request.getSession().setAttribute("errorMessage", "");

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        PrintWriter out = response.getWriter();
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        System.out.println("Connected");
        DB db = mongo.getDB( "HardWHERE" );

        DBCollection coll = db.getCollection("companies");
        DBObject query = new BasicDBObject("username", username);
        DBCursor cursor = coll.find(query);

        BasicDBObject fields = new BasicDBObject("password", 1).append("name", 1);
        DBObject d1 = coll.findOne(query, fields);

        if(cursor.hasNext()){

            request.getSession().setAttribute("errorMessage", "");
            String pass=(d1.get("password")).toString();
            if(password.equals(d1.get("password"))){
                //request.setAttribute("name",(d1.get("name")).toString());
                //request.setAttribute("id", (d1.get("id")).toString());


                //request.getRequestDispatcher("/dashbord.jsp").forward(request,response);

                out.println(d1);
                //out.println(d1.get("name"));
                //out.println(d1.get("id"));

            }else{
                request.getSession().setAttribute("errorMessage", "Password incorrect");
                response.sendRedirect(request.getHeader("Referer"));
                //request.getSession().setAttribute("errorMessage", "");
            }
        }else{

            request.getSession().setAttribute("errorMessage", "User name incorrect");
            response.sendRedirect(request.getHeader("Referer"));
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            //out.println(cursor.next());
        }
    }
}
