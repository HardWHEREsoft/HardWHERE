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
    <div class="col-md-6" style="text-align:right; margin-top:20px"> <button class="btn btn-sm">logout</button> </div>
  </div><!-- /.navbar-collapse -->

</nav>

<div class="container">
  <div class="row">
    <div class="col-md-4"><h3>Hi <span>${User}</span>,</h3></div>
    <div class="col-md-4">
      <h1 style="text-align:center">MY DASHBOARD</h1>
      <hr>
    </div>
    <div class="col-md-4" style="text-align:center; margin-top:20px">

      <button class="btn btn-primary">Add New Item</button>
    </div>
  </div>
</div>

<!--2 buttons show info and add item-->
<section class="div_padding">
  <div class="container text-center">
    <div class="col-md-2 col-xs-6"><input  type="submit" class="btn btn-default" value="My Items" onclick="alertMe();"></div>
    <div class="col-md-2 col-xs-6"><a href="additem.jsp" class="btn btn-default">Add Item</a></div>
  </div>
  <hr>
</section>

<section class="div_padding">
  <div class="container" >
    <div class="row">
      <div class="col-md-4">
        <div class="row"></div>

        <div class="row">
          <h4><u>My Messages</u></h4>
          <table class="table table-hover">
            <tr><td>User1 <br>df fdkfsl fs fskdf ldsf sdf sdfkmf srf dfkd fdkf dfgk dfg g<hr></td></tr>
            <tr><td>User1 <br>df fdkfsl fs fskdf ldsf sdf sdfkmf srf dfkd fdkf dfgk dfg g<hr></td></tr>
            <tr><td>User1 <br>df fdkfsl fs fskdf ldsf sdf sdfkmf srf dfkd fdkf dfgk dfg g<hr></td></tr>
          </table>
          <button class="btn btn-primary">See All Messages</button>
        </div>
      </div>

      <div class="col-md-8">
        <h4><u>Statistics</u></h4>
        <img src="img/Stats.gif" class="img-responsive">
      </div>
    </div>

  </div>
</section>

<footer>
  <div class="text-center">
    <div class="row top">Contact Us</div>
    <div class="row bottom">copyrights &copy; HardWhereSoft</div>
  </div>

</footer>


</body>
</html>