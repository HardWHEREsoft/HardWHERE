<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sms.sample.Items" %>
<%@ page import="com.sms.sample.Query" %>
<%--
  Created by IntelliJ IDEA.
  User: Ehelepola
  Date: 05/07/2015
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>consumerGoods</title>
  </head>
  <body>

    <form action="query" method="get">

      <textarea name="search" rows="1" cols="50" ></textarea>
      <input type="submit" value="search">

    </form>

  <div>
    <%
      ArrayList<Items> items;

      items=new Query().getItemsByrPrice(request.getParameter("search"));
      for(int i=0;i<items.size();i++){

        out.println("-------------------------------------<br>");
        out.println("name: "+items.get(i).getName());
        out.println("Shop name: "+items.get(i).getShopName());
        out.println("Contact: "+items.get(i).getContact());
        out.println("Description: "+items.get(i).getDescription());
        out.println("Image: "+items.get(i).getImage());
        out.println("Price: "+items.get(i).getPrice());
        out.println("District: "+items.get(i).getDistrict());
        out.println("-------------------------------------<br>");
      }

    %>


  </div>

  </body>
</html>
