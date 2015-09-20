<%--
  Created by IntelliJ IDEA.
  User: menaka
  Date: 9/21/15
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.hardwhere.controller.servlets.Query" %>
<%@ page import="com.hardwhere.model.Item_POJO" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/typeahead.bundle.js"></script>
  <script type="text/javascript" src="js/animation.js"></script>


  <title>HardWHERE</title>

</head>

<body id="page-top" class="index">

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <h1 class="col-md-6"><a href="index.jsp"> HardWHERE.lk</a></h1>
  </div><!-- /.navbar-collapse -->
</nav>




<div id="error">
  <p>${Message}</p>

</div>


</body>
</html>