package com.hardwhere.controller.servlets;

import com.hardwhere.controller.javaclasses.ConvertToPOJO;
import com.hardwhere.controller.javaclasses.InsertIntoDB;
import com.hardwhere.controller.javaclasses.MongoDBConnection;
import com.hardwhere.model.Companies;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menaka on 7/12/15.
 */
public class Register extends HttpServlet {

    private Companies company;
    MongoDBConnection conn = new MongoDBConnection();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        this.company = new Companies();
        request.getSession().removeAttribute("errorMessage1");
        request.getSession().setAttribute("errorMessage1", "");

        //Create the class
        String id = String.valueOf(System.nanoTime());
        this.company.setCompany_Name(request.getParameter("name"));
        this.company.setCompany_Address_line1(request.getParameter("address1"));
        this.company.setCompany_Address_line2(request.getParameter("address2"));
        this.company.setCompany_Address_line3(request.getParameter("address3"));
        this.company.setCpmpanyID(id);
        this.company.setDistrict(request.getParameter("district"));
        this.company.setEmail(request.getParameter("email"));
        this.company.setPostcode(request.getParameter("postal"));
        this.company.setUserName(request.getParameter("username"));
        this.company.setPassword(request.getParameter("password"));
        this.company.setTelephone(request.getParameter("tel"));


        DBObject query = new BasicDBObject("username", this.company.getUserName());
        if(conn.check(this.company.getUserName())){
            this.enterData();
        }else{
            request.getSession().setAttribute("errorMessage1", "User name alredy exists");
            try {
                response.sendRedirect(request.getHeader("Referer"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
            request.getSession().setAttribute("errorMessage", "");
        }
 }

    public void enterData(){
        conn.createConnection("company");
        InsertIntoDB idb = new InsertIntoDB(this.company);
        System.out.println();
        ConvertToPOJO cp = new ConvertToPOJO((BasicDBObject)idb.toDBObject("company"));
        System.out.println(cp.convertCom().toString());



    }

}
