<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hardwhere.model.Item_POJO" %>
<%--
  Created by IntelliJ IDEA.
  User: menaka
  Date: 7/11/15
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Dashboard</title>

  <%
    String s = (String)request.getAttribute("services");
    request.setAttribute("user_id", null);
    ArrayList<Item_POJO> items = (ArrayList<Item_POJO>) request.getAttribute("items");
    String d = "Hi";
    System.out.println(d);
  %>

</head>
<body>
<div id="container">
  <div id="header">This is header</div>
  <div id="content">
    <div id="shop_image">Profile Image Goes here</div>
    <div id="profile_Content">
      <a href="additem.jsp">Add items to your shop</a>
      <form action="dashboard" method="post">
        <input type="submit" id="seeMyItems" name="See my items" value="See my items">
      </form>
      <div id="myItems">
        <div id="myServices">
          <h4>My Services</h4>
          <%=d%>
        </div>
        <div id="myEquipments"></div>
        <div id="myMaterials"></div>
      </div>
    </div>
  </div>

  <div id="footer">This is footer</div>
</div>
</body>
</html>