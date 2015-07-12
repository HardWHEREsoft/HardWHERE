<%--
  Created by IntelliJ IDEA.
  User: menaka
  Date: 7/11/15
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add items</title>
</head>
<body>

<div id="container">
  <div id="header">

  </div>
  <div>
    <%
      String message = (String)request.getAttribute("Result");
    %>
    <%=message==null?"":message%>
  </div>
  <div id="form">
    <form id="addItemForm" action="additem" method="post" enctype="multipart/form-data">
      <table id="formTable">
        <tr><td>Item Name: </td> <td><input type="text" name="item_Name" id="itemName"></td></tr>
        <tr><td>Item Description: </td><td><textarea id="itemDescription" name="item_description" rows="10" cols="20"></textarea></td></tr>
        <tr><td>Type: </td><td><select id="itemType" name="item_Type">
          <option>Service</option>
          <option>Material</option>
          <option>Equipment</option>
        </select></td></tr>
        <tr><td>Item Price: </td><td><input type="text" name="item_price" id="itemPrice"></td></tr>
        <tr><td>Item Image: </td><td><input type="file" name="file" size="50"></td></tr>
        <tr><td></td><td><input type="submit" value="Add Item"></td></tr>
      </table>
    </form>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>