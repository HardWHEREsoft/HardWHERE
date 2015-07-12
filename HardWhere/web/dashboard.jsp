<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hardwhere.model.Item_POJO" %>
<%--
  Created by IntelliJ IDEA.
  User: menaka
  Date: 7/11/15
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <h1 class="col-md-6">HardWHERE.lk</h1>
  </div>
</nav>

<!--2 buttons show info and add item-->
<section class="div_padding">
  <div class="container text-center">
    <div class="col-md-2 col-xs-6"><input  type="submit" class="btn btn-default" value="My Items" onclick="alertMe();"></div>
    <div class="col-md-2 col-xs-6"><a href="additem.jsp" class="btn btn-default">Add Item</a></div>
  </div>
  <hr>
</section>

<!--# columns to sho details-->
<section class="div_padding">
  <div class="container text-center show-hide" hidden="hidden">
    <div class="col-md-3 col-xs-12 rcorners">
      <h4>My Material</h4>
      <ul class="text-left">
        <li>Cement</li>
        <li>Sand</li>
        <li>Lime</li>
        <li>Cement</li>
        <li>Cement</li>
      </ul>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-3 col-xs-12 rcorners">
      <h4>My Services</h4>
      <ul class="text-left">
        <li>Lorries</li>
        <li>Bull Dozers</li>
        <li>Masons</li>
        <li>Quantity Surveyors</li>
        <li>Engineers</li>
      </ul>

    </div>

    <div class="col-md-1"></div>
    <div class="col-md-3 col-xs-12 rcorners">
      <h4>My Equipments</h4>
      <ul class="text-left">
        <li>Hammers</li>
        <li>Drill</li>
      </ul>
    </div>
  </div>
  <div class="row" style="margin-bottom: 30px"></div>
</section>

<footer>
  <div class="text-center">
    <div class="row top">Contact Us</div>
    <div class="row bottom">copyrights &copy; HardWhereSoft</div>
  </div>

</footer>


</body>
</html>