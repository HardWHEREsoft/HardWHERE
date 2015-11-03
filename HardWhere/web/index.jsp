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
    <h1 class="col-md-6"><a href="#"> HardWHERE.lk</a></h1>

    <form class="navbar-form navbar-right col-md-6" role="search" method="post" action="loginPage">

      <div class="form-group">
        <input type="text" class="form-control input-sm" placeholder="E-mail" name="username">
        <input type="password" class="form-control input-sm" placeholder="Password" name="password">
      </div>
      <button type="submit" class="btn btn-sm">login</button>

      <div></div>
    </form>
  </div><!-- /.navbar-collapse -->
</nav>

<section class="div_padding">
  <div class="container text-center">
    <h4>Have you not registered yet? <a href="registration.jsp">SignUp Here Now</a></h4>
  </div>
  <hr>
</section>

<!--This is to contain details of the project-->
<section class="div_padding">
  <div class="container">

    <!--   Row1     -->
    <div class="row">
      <div class="col-md-6">
        <a>
          <h3>Bricks & Blocks</h3>
          <img src="img/index/Bricks.png">
        </a>
      </div>

      <div class="col-md-6">
        <a>
          <h3>Paint & Accessories</h3>
          <img src="img/index/paint.png">
        </a>
      </div>
    </div>

    <!--   Row2     -->
    <div class="row">
      <div class="col-md-6">
        <a href="search?item_Type=Material&itemModel=Tile">
          <h3>Tiles (Falls & Walls)</h3>
          <img src="img/index/Tiles.png">
        </a>
      </div>

      <div class="col-md-6">
        <a>
          <h3>Plywood Laminates Veneers</h3>
          <img src="img/index/Plywood.png">
        </a>
      </div>
    </div>

    <!--   Row3     -->
    <div class="row">
      <div class="col-md-6">
        <a>
          <h3>Electrical Products & Accessories</h3>
          <img src="img/index/elec.png">
        </a>
      </div>

      <div class="col-md-6">
        <a>
          <h3>Bathroom Fittings & Accessories</h3>
          <img src="img/index/Bathroom.png">
        </a>
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