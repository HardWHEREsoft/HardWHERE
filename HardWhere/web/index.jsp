<%@ page import="com.hardwhere.controller.servlets.Query" %>
<%@ page import="com.hardwhere.model.Item_POJO" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: menaka
  Date: 7/11/15
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>HardWHERE</title>
  </head>
  <body>
  <a href="additem.jsp">Add Items</a>
  <form action="query" method="get">

    <input type="text" name="search" rows="1" cols="50" onkeyup="showSuggestion(this.value)" >

    <input type="submit" value="search">

  </form>
  
      
    <div>
    <%
      ArrayList<Item_POJO> items;

      items=new Query().getItemsByrPrice(request.getParameter("search"));
      for(int i=0;i<items.size();i++){
        out.println("-------------------------------------<br>");
        out.println("name: ");
        out.println("<a href=\"item?item_id="+items.get(i).getItem_ID()+"\""+">"+items.get(i).getItem_Name()+" </a>");
        out.println("Shop name: "+items.get(i).getUser());
//        out.println("Contact: "+items.get(i).getContact());
        out.println("Description: "+items.get(i).getItem_Description());
        out.println("Image: "+items.get(i).getItem_Image());
        out.println("Price: "+items.get(i).getItem_Price());
//        out.println("District: "+items.get(i).getDistrict());
          out.println(" <div>");
      }

    %>


  </div>

  </body>
</html>