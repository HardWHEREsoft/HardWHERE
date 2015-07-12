<%--
  Created by IntelliJ IDEA.
  User: menaka
  Date: 7/12/15
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration</title>
</head>
<body>
<h1>Registration </h1>

<form name="frm1" action="register" method="POST">

  <table>
    <tr><td>Name: </td><td><input type="text" name="name" value="" size="100" /></td></tr>
    <tr><td>Address1: </td><td><input type="text" name="address1" value="" size="100" /></td></tr>
    <tr><td>Address2: </td><td><input type="text" name="address2" value="" size="100" /></td></tr>
    <tr><td>Address3: </td><td><input type="text" name="address3" value="" size="100" /></td></tr>
    <tr><td>District: </td><td><input type="text" name="district" value="" size="100" /></td></tr>
    <tr><td>Postal Code: </td><td><input type="text" name="postal" value="" id="postcode"></td></tr>
    <tr><td>Tel: </td><td><input type="text" name="tel" value="" size="100" /></td></tr>
    <tr><td>Email: </td><td><input type="text" name="email" value="" size="100" /></td></tr>

  </table>


  <!--select name="districtlist" size="5" disabled="disabled">
      <option value="gampaha">Gampaha</option>
      <option value="colombo">Colombo</option>
      <option value="kaluthara">Kaluthara</option>
      <option value="jaffna">Jaffna</option>
      <option value="kilinochchi">Kilinochchi</option>
  </select-->

  <div style="color: #FF0000;">${errorMessage1}</div>
  <table>
    <tr><td>User Name: </td><td><input type="text" name="username" value="" size="100" /></td></tr>
    <tr><td>Password: </td><td><input type="password" name="password" value="" size="100" /></td></tr>
    <tr><td><input type="submit" value="Submit"></td></tr>
  </table>

</form>

</body>
</html>
