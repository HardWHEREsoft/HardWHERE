package com.hardwhere.controller.servlets;

import com.hardwhere.controller.javaclasses.ConvertToPOJO;
import com.hardwhere.controller.javaclasses.InsertIntoDB;
import com.hardwhere.controller.javaclasses.MongoDBConnection;
import com.hardwhere.model.Companies;
import com.hardwhere.model.Person;
import com.mongodb.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by menaka on 7/12/15.
 */
public class Register extends HttpServlet {


    private Person owner;
    private Companies company;
    MongoDBConnection conn = new MongoDBConnection();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        this.owner = new Person();
//        this.company = new Companies();
        request.getSession().removeAttribute("errorMessage1");
        request.getSession().setAttribute("errorMessage1", "");

        this.owner.setName(request.getParameter("name"));
        this.owner.setAddress1(request.getParameter("address1"));
        this.owner.setAddress2(request.getParameter("address2"));
        this.owner.setAddress3(request.getParameter("address3"));
        this.owner.setEmail(request.getParameter("email"));
        this.owner.setNic(request.getParameter("nic"));
        this.owner.setTelephone(request.getParameter("tel"));
        this.owner.setPoastalCode(request.getParameter("postal"));
        this.owner.setDistrict(request.getParameter("district"));

        //For logging
        this.owner.setUserName(request.getParameter("username"));
        this.owner.setPassword(request.getParameter("password"));


        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "localhost" , 27017 );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DB mongoDatabase = mongoClient.getDB("HardWHERE");
        DBCollection col=mongoDatabase.getCollection("owners");
        DBObject query = new BasicDBObject("username", this.owner.getUserName());
        DBCursor cursor = col.find(query);

        if(cursor.hasNext()){
            request.getSession().setAttribute("Message", "User name alredy exists");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/erorpage.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                response.sendRedirect(request.getHeader("Referer"));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            request.getSession().setAttribute("Message", "");
        }else{
            this.enterData(col);
            request.getSession().setAttribute("customer", this.owner.getEmail());
            request.getSession().setAttribute("User", this.owner.getName());
            RequestDispatcher dispatcher = request.getRequestDispatcher("company_reg.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void enterData(DBCollection col){


        BasicDBObject owner = new BasicDBObject();
        owner.append("name", this.owner.getName());
        owner.append("username", this.owner.getUserName());
        owner.append("password", this.owner.getPassword());
        owner.append("address1", this.owner.getAddress1())
                .append("address2", this.owner.getAddress2())
                .append("address3", this.owner.getAddress3())
                .append("post", this.owner.getPoastalCode())
                .append("email", this.owner.getEmail())
                .append("district", this.owner.getDistrict());


//
//        DB mongoDatabase = mongoClient.getDB("HardWHERE");
//        DBCollection col=mongoDatabase.getCollection("owners");
        col.insert(owner);

//        conn.createConnection("owner");
//        InsertIntoDB idb = new InsertIntoDB(this.owner);
//        System.out.println();
//        ConvertToPOJO cp = new ConvertToPOJO((BasicDBObject)idb.toDBObject("owner"));
//        System.out.println(cp.convertCom().toString());
    }

}
