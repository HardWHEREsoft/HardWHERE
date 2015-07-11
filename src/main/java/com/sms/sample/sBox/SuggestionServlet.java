package com.sms.sample.sBox;

import com.mongodb.*;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SuggestionServlet  extends HttpServlet
{

    //String[] names = {"Abbot", "Abraham","Adam","Adrian","Barack","Babara","Barney","Becky","Calvin","Camilia","Charley","Chuck","Daniel","Daisy","Damien","Dean"};	//array containing the names which would be displayed as suggestions

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String[] names=getNames();
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("userInput").toLowerCase();			//getting the parameter which was sent by the client
        Pattern inputPattern = Pattern.compile("^"+input + ".*");				//create a Pattern object according to the user input
        Matcher match;
        int found = 0;
        String name ="";

        for(int i=0;i<names.length;i++){
            match = inputPattern.matcher(names[i].toLowerCase());
            if(match.find()){
                name += names[i]+" ";
                found++;
            }
        }

        out.println(name);


        //compare each name in the names array with the user input pattern and when a matching name is found send that in the response



    }
    public String [] getNames() throws UnknownHostException {
        int i=0;

        Mongo m = new Mongo("localhost",27017);
        DB db = m.getDB("consumerGoods");
        DBCollection coll = db.getCollection("items");
//        BasicDBObject query = new BasicDBObject();
//        query.put("name", "paint");
        DBCursor cursor = coll.find();
        System.out.println(cursor.count());
        String [] names = new String[cursor.count()];
        String str;
        while (cursor.hasNext()) {
            BasicDBObject document= (BasicDBObject) cursor.next();
            System.out.println(document);
            str= (String) document.get("name");
            System.out.println(str);
            names[i]=str;

            i++;
        }
        return names;
    }

}