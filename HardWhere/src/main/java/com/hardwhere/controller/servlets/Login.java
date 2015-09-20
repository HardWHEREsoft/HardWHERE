package com.hardwhere.controller.servlets;

import com.mongodb.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by menaka on 7/12/15.
 */
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Mongo m = null;

    public void init(ServletConfig config)
    {
        try {
            m = new Mongo( "localhost" );
            System.out.println("Connected");
        } catch (UnknownHostException e) {
            e.printStackTrace();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
//        PrintWriter out = response.getWriter();
        DB db = m.getDB( "HardWHERE" );

        DBCollection coll = db.getCollection("owners");
        DBObject query = new BasicDBObject("username", username);
        DBCursor cursor = coll.find(query);
        if(cursor.hasNext()){
            BasicDBObject owner = (BasicDBObject) cursor.next();
            if(owner.get("username").equals(username) && owner.get("password").equals(password)){
                System.out.println("Successful");
                request.getSession().setAttribute("User", username);
                dispatcher.forward(request, response);

            }else{

                RequestDispatcher dispatcher1 = request.getRequestDispatcher("/erorpage.jsp");
                request.getSession().setAttribute("Message", "Invalid password");
                dispatcher1.forward(request, response);
            }
        }else{
            RequestDispatcher dispatcher1 = request.getRequestDispatcher("/erorpage.jsp");
            request.getSession().setAttribute("Message", "Invalid email or password");
            dispatcher1.forward(request, response);
        }

//        BasicDBObject fields = new BasicDBObject("password", 1).append("name", 1);
//        DBObject d1 = coll.findOne(query, fields);
//
//
//
//
//        if(username.equals(coll.) && password.equals("1234")){
//
//        }else{
//            RequestDispatcher dispatcher1 = request.getRequestDispatcher("/index.jsp");
//            request.setAttribute("Message", "Invalid email or password");
//            dispatcher1.forward(request, response);
//        }

//        if(cursor.hasNext()){
//
//            request.getSession().setAttribute("errorMessage", "");
//            String pass=(d1.get("password")).toString();
//            if(password.equals(d1.get("password"))){
//
//                //String name2= (d1.get("name")).toString();
//                //String id2= (d1.getString("name"));
//                //out.println(name2);
//                System.out.println(d1);
//
//                //request.setAttribute("name","sew");
//                //request.setAttribute("id", "12");
//                //request.getRequestDispatcher("/dashbord.jsp").forward(request,response);
//
////                out.println(d1);
//                //out.println(d1.get("name"));
//                //out.println(d1.get("id"));
//
//            }else{
//                request.getSession().setAttribute("errorMessage", "Password incorrect");
//                response.sendRedirect(request.getHeader("Referer"));
//            }
//        }else{
//
//            request.getSession().setAttribute("errorMessage", "User name incorrect");
//            response.sendRedirect(request.getHeader("Referer"));
//            //request.getRequestDispatcher("/index.jsp").forward(request, response);
//            //out.println(cursor.next());
//        }
    }
}
