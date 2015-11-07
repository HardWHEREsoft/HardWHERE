<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hardwhere.model.Item_POJO" %>
<%@ page import="com.hardwhere.controller.servlets.Query" %>
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
    
<section class="div_padding">
    <div class="container">
        <div class="row">
            <form class="form" method="get" action="search">
            <!--    This is the filter        -->
            <div id="filter" class="col-md-2 col-xs-4">
                  <a><h4>Brand</h4></a>
                  <div class="row show-hide-div">
                    <div class="col-md-12 col-xs-12"><input name="itemBrand" type="checkbox" value="AGL"> AGL</div>
                    <div class="col-md-12 col-xs-12"><input name="itemBrand" type="checkbox">Lanka_Tiles</div>
                    <div class="col-md-12 col-xs-12"><input name="itemBrand" type="checkbox">Royal_Ceramic</div>
                  </div>
                
                <hr>
                  <a><h4>Size</h4></a>
                  <div class="row show-hide-div2" hidden="hidden">
                    <div class="col-md-12 col-xs-12"><input name="itemSize" type="checkbox" value="200x200"> 200 X 1200 (mm)</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemSize" type="checkbox" value="300x300"> 300 X 300 (mm)</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemSize" type="checkbox" value="150x150"> 150 x 150 (mm)</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemSize" type="checkbox" value="445x445"> 445 X 445 (mm)</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemSize" type="checkbox" value="600x1200"> 600 X 1200 (mm)</a></div>
                  </div>
                
                <hr>
                  <a><h4>Thickness</h4></a>
                  <div class="row show-hide-div3" hidden="hidden">
                    <div class="col-md-12 col-xs-12"><input name="itemThickness" type="checkbox" value="25mm"> 25mm</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemThickness" type="checkbox" value="75mm"> 75mm</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemThickness" type="checkbox" value="50mm"> 50mm</a></div>
                    <div class="col-md-12 col-xs-12"><input name="itemThickness" type="checkbox" value="60mm"> 60mm</a></div>
                  </div>
                <hr>
                <input type="submit" class="btn btn-primary" value="Filter">
                <input type="hidden" name="item_Type" value="Material"/>
                <input type="hidden" name="itemModel" value="Tile"/>
                
            </div>
                
        </form>
            
            <!--     Content       -->
            <div id="content" class="col-md-10 col-xs-8">
                <h3>Content</h3>
                
                <div class="row">
                    
                    <%
                        ArrayList<Item_POJO> arrayList=new ArrayList<>();
                        String item_Type=request.getParameter("item_Type");
                        String itemModel=request.getParameter("itemModel");
                        String itemBrand=request.getParameter("itemBrand");
                        String itemSize=request.getParameter("itemSize");
                        String itemThickness=request.getParameter("itemThickness");
                        Query query=new Query();
                        arrayList=query.getItemList(item_Type, itemModel, itemBrand, itemSize, itemThickness);
                        Item_POJO item_pojo=new Item_POJO();
                        for(int i=0;i<arrayList.size();i++){
                            item_pojo=arrayList.get(i);
                            out.println("<div class=\"itemDisplay col-md-3 col-xs-6\">");
                            out.println("<img class=\"img-responsive\" src=\"/img/test/"+item_pojo.getItem_Image()+"\">");
                            out.println("<p>Details:"+item_pojo.getItem_Brand()+"</p>");
                            out.println("<p>Price:"+item_pojo.getItem_Price()+"</p>");
                            out.println("<button class=\"btn\"><a href=\"item?item_ID="+item_pojo.getItem_ID()+"\">MORE INFO</a></button>");
                            out.println("</div>");
                        }

                    %>
                    
                    <%--<div class="itemDisplay col-md-3 col-xs-6">--%>
                        <%--<img class="img-responsive" src="img/test/3.jpg">--%>
                        <%--<p>Details</p>--%>
                        <%--<p>Price</p>--%>
                        <%--<button class="btn"><a href="item?Item_ID=">MORE INFO</a> </button>--%>
                    <%--</div>--%>
                    
                    <%--<div class="itemDisplay col-md-3 col-xs-6">--%>
                        <%--<img class="img-responsive" src="img/test/3D-Wallpaper-of-Lake-and-Moon-Wallpaper-Backgrounds-HD-Wallpapers.jpg">--%>
                        <%--<p>Details</p>--%>
                        <%--<p>Price</p>--%>
                        <%--<button class="btn">MORE INFO</button>--%>
                    <%--</div>--%>
                    <%----%>
                    <%--<div class="itemDisplay col-md-3 col-xs-6">--%>
                        <%--<img class="img-responsive" src="img/test/profilePic.png">--%>
                        <%--<p>Details</p>--%>
                        <%--<p>Price</p>--%>
                        <%--<button class="btn">MORE INFO</button>--%>
                    <%--</div>--%>
                    <%----%>
                    <%--<div class="itemDisplay col-md-3 col-xs-6">--%>
                        <%--<img class="img-responsive" src="img/test/3D-Morning-Dew-HD-Wallpaper.jpg">--%>
                        <%--<p>Details</p>--%>
                        <%--<p>Price</p>--%>
                        <%--<button class="btn">MORE INFO</button>--%>
                    <%--</div>--%>
                    <%----%>
                    <%--<div class="itemDisplay col-md-3 col-xs-6">--%>
                        <%--<img class="img-responsive" src="img/test/3D-Morning-Dew-HD-Wallpaper.jpg">--%>
                        <%--<p>Details</p>--%>
                        <%--<p>Price</p>--%>
                        <%--<button class="btn">MORE INFO</button>--%>
                    <%--</div>--%>
                    <%----%>
                    <%--<div class="itemDisplay col-md-3 col-xs-6">--%>
                        <%--<img class="img-responsive" src="img/test/3D-Morning-Dew-HD-Wallpaper.jpg">--%>
                        <%--<p>Details</p>--%>
                        <%--<p>Price</p>--%>
                        <%--<button class="btn">MORE INFO</button>--%>
                    <%--</div>--%>
                    
                </div>
                
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