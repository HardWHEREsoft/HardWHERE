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
    String s = (String)request.getAttribute("Message");
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
          <%=s==null?"":s%>
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