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
    <h1 class="col-md-6">HardWHERE.lk</h1>

    <form class="navbar-form navbar-right col-md-6" role="search">
      <div class="form-group">
        <input type="text" class="form-control input-sm" placeholder="E-mail">
        <input type="password" class="form-control input-sm" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-sm">login</button>
    </form>
  </div><!-- /.navbar-collapse -->
</nav>

<section class="div_padding">
  <div class="container text-center">
    <h4>Have you not registered yet? <a href="">SignUp Here Now</a></h4>
  </div>
  <hr>
</section>

<!--Sorting Area-->
<section class="sorting div_padding text-center bottom_border">
  <div class="container">
    <div class="row">
      <!--Sorting div-->
      <form class="form-horozontal" method="get" action="">
        <div class="form-group">
          <div class="col-md-4 selectContainer text-left">
            <select id="select_dist" class="form-control" id="district">
              <option>--Select District--</option>
              <option>Kegalle</option>
              <option>Mawanella</option>
              <option>Mathara</option>
            </select>
          </div>

          <div class="col-md-2">
            <label class="checkbox large text"><input type="checkbox" value="">Sort by price</label>
          </div>

          <div class="col-md-6 text-inline">

            <form action="query" method="get">
              <div class="col-md-6">
                <label for="seach">
                  <input id="search" name="search" type="search" style="width:120%" class="form-control input-md col-md-4" placeholder="search item">
                </label>
              </div>
              <div class="mol-md-4">
                <input type="submit" value="Search" class="btn btn-default">
              </div>
            </form>
          </div>

        </div>
      </form>

    </div>

    <!--View Area-->
    <div class="col-md-8 view">

    </div>
  </div>
  <hr class="phone-visible">
</section>




<!--Catagory Slide-->
<section class="div_padding">
  <div class="container">
    <a><h3 onclick="alertMe();">Catagaries</h3></a>
    <div id="categories" class="row show-hide" hidden="hidden">
      <a><h4>Materials</h4></a>
      <div class="row show-hide-div" hidden="hidden">
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
      </div>
      <a><h4>Equipments</h4></a>
      <div class="row show-hide-div2" hidden="hidden">
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
      </div>
      <a><h4>Services</h4></a>
      <div class="row show-hide-div3" hidden="hidden">
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
        <div class="col-md-2 col-xs-4"><a>Cement</a></div>
      </div>
    </div>
  </div>
  <hr>
</section>





<!--Table after getting tesults-->
<section class="result_table div_padding">
  <div class="row">
    <div class=" container col-md-offset-3 col-md-6">
      <table class="table table-hover">
        <tbody>

        <%
          ArrayList<Item_POJO> items;

          items=new Query().getItemsByrPrice(request.getParameter("search"));
          for(int i=0;i<items.size();i++){
            out.println("<tr>");
            out.println("<td class=\"col-md-2 img-item\"><img class=\"img-responsive\" src=\"img/profilePic.png\"></td>");
            //out.println("<a href=\"item?item_id="+items.get(i).getItem_ID()+"\""+">"+items.get(i).getItem_Name()+" </a>");
            out.println("<td>");
            out.println("<div class=\"row\">"+"<a href=\"item?item_id="+items.get(i).getItem_ID()+"\""+">"+items.get(i).getItem_Description()+" </a>"+"</div>");

            //out.println("Image: "+items.get(i).getItem_Image());
            //        out.println("District: "+items.get(i).getDistrict());
            out.println("<div class=\"row\">"+"RS:"+items.get(i).getItem_Price()+"</div>");
            out.println("<div class=\"row\">"+"shop name:"+items.get(i).getUser()+"</div>");
            out.println("</td>");
            out.println("</tr>");
          }
        %>


        </tbody>
      </table>
    </div>
  </div>
  <hr>
</section>

<footer>
  <div class="text-center">
    <div class="row top">Contact Us</div>
    <div class="row bottom">copyrights &copy; HardWhereSoft</div>
  </div>

</footer>

</body>
</html>