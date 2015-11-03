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
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/typeahead.bundle.js"></script>
  <script type="text/javascript" src="js/animation.js"></script>
  <script type="text/jscript" src="js/additem.js"></script>
</head>

<body id="page-top" class="index">
<div>
  <%
    String message = (String)request.getAttribute("Result");
  %>
  <%=message==null?"":message%>
</div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <h1 class="col-md-6"><a href="index.jsp"> HardWHERE.lk</a></h1>
  </div><!-- /.navbar-collapse -->
</nav>

<section class="div_padding">
  <div class="container"><h2><u>ADD NEW ITEM</u></h2></div>
  <hr>
</section>

<section class="div_padding">
  <div class="container" style="">

    <!--        Select the Type-->
    <table class="table">
      <div class="form-group">
        <td class="col-lg-2"><h4>Type</h4></td>
        <td class="col-lg-10">
          <select class="form-control" id="type" onchange="selectType();" style="width:30%">
            <option value="Material">Material</option>
            <option value="Equipment">Equipment</option>
            <option value="Service">Service</option>
          </select>
        </td>
      </div>
    </table>
    <hr>

    <!--        Form-->
    <form class="form" id="form_add" method="post" action="additem">

      <table class="table">

        <tr id="mat_type">
          <div class="form-group">
            <td class="col-lg-2"><h4>Type of Material</h4></td>
            <td class="col-lg-10">
              <select name="itemModel" class="form-control" id="type_mat" onchange="selectTile();" style="width:30%">
                <option value="Bricks">Bricks</option>
                <option value="Paint">Paint</option>
                <option value="Tile">Tile</option>
                <option value="Plywood">Plywood</option>
                <option value="Electrical">Electrical</option>
                <option value="Bathroom">Bathroom Fittings</option>
              </select>
            </td>
          </div>
        </tr>

        <tr id="tile_brands" hidden="hidden">
          <div class="form-group">
            <td class="col-lg-2"><h4>Brand</h4></td>
            <td class="col-lg-10">
              <select name="itemBrand" class="form-control" id="type" onchange="" style="width:30%">
                <option value="Lanka_Tiles">Lanka Tiles</option>
                <option value="Royal_Ceramic">Royal Ceramic</option>
                <option value="AGL">AGL</option>
              </select>
            </td>
          </div>
        </tr>

        <tr id="name_tr">
          <div class="form-group">
            <td class="col-lg-2"><h4 id="name">Item Name</h4></td>
            <td class="col-lg-10"><input type="text" name="item_Name" class="form-control col-lg-8" placeholder="Item Name"></td>
          </div>
        </tr>

        <tr id="thickness_tr">
          <div class="form-group">
            <td class="col-lg-2"><h4 id="thickness">Item Thickness</h4></td>
            <td class="col-lg-10"><input type="text" name="itemThickness" class="form-control col-lg-8" placeholder="Item Thickness"></td>
          </div>
        </tr>

        <tr id="size_tr">
          <div class="form-group">
            <td class="col-lg-2"><h4 id="size">Item Size</h4></td>
            <td class="col-lg-10"><input type="text" name="itemSize" class="form-control col-lg-8" placeholder="Item Size"></td>
          </div>
        </tr>

        <tr id="desc_tr">
          <div class="form-group">
            <td class="col-lg-2"><h4 id="desc">Item Description</h4></td>
            <td class="col-lg-10"><textarea name="item_description" cols="5" rows="5" class="form-control" placeholder="Description about 100 words"></textarea></td>
          </div>
        </tr>

        <tr id="price_tr">
          <div class="form-group row">

            <td class="col-md-2"><h4>Price</h4></td>
            <td class="col-md-5"><input name="itemPrice" type="text" placeholder="Price" class="form-control" style="300px"></td>
            <td class="col-md-5"><h4 id="price"> Per Unit</h4></td>
          </div>
        </tr>

        <tr>
          <div class="form-group">
            <td class="col-lg-2"><h4>Item Image</h4></td>
            <td class="col-lg-10"><input  type="file" name="file" size="50"></td>
          </div>

        </tr>

        <tr id="submit_tr">
          <td>
            <div>
              <input  id="hiding" type="hidden" name="item_Type" value="Material">
            </div>

            <div class="form-group">
              <input type="submit" value="Add Item" class="btn btn-primary">
            </div>
          </td>
        </tr>

      </table>
    </form>
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