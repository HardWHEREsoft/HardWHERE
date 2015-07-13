<%@ page import="com.hardwhere.model.Item_POJO" %>
<%@ page import="com.hardwhere.controller.servlets.itemDetails" %>
<%--
  Created by IntelliJ IDEA.
  User: Ehelepola
  Date: 12/07/2015
  Time: 02:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%

  Item_POJO items;

  items=new itemDetails().getItemsByrPrice(request.getParameter("item_id"));


%>
<head>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/typeahead.bundle.js"></script>
  <script type="text/javascript" src="js/animation.js"></script>
  <title>HardWHERE</title>
  <style type="text/css">
    html, body, #map-canvas { height: 100%; margin: 0; padding: 0;}
  </style>

  <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
  <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=geometry"></script>
  <script type="text/javascript">


    function homeMap(address){
      var latitude = 0;
      var longitude= 0;
      var x = document.getElementById("demo");
      var geocoder = new google.maps.Geocoder();
      //var address = "ettampitiya";
      geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          latitude = results[0].geometry.location.lat();
          longitude = results[0].geometry.location.lng();
        }
      });

      function initialize() {
        var myLatlng = new google.maps.LatLng(latitude, longitude);
        var mapOptions = { zoom: 17, center: myLatlng}
        var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
        var marker = new google.maps.Marker({ position: myLatlng, map: map, draggable:true, title:"Drag me!"});}
      google.maps.event.addDomListener(window, 'load', initialize);
    }
    homeMap("matale");
  </script>
</head>
<body id="page-top" class="index">


    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <h1 class="col-md-6">HardWHERE.lk</h1>
      </div>
    </nav>

    <section class="div_padding">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <table class="table table-striped">
              <tbody>
              <tr><td>Item Name</td></tr>
              <tr><td>Address</td></tr>
              <tr><td>Service</td></tr>
              <tr><td>Shop Name</td></tr>
              <tr><td>Contact</td></tr>
              </tbody>
            </table>
          </div>
          <div class="col-md-8"><h3>Position</h3>
            <div id="map-canvas" style="width:500px;height:380px;">
          </div>
        </div>

        <div class="row  text-center" style="margin-bottom:30px margin-top:30px">
          <button id="callBtn" class="btn btn-default">Call</button>
        </div>

      </div>
    </section>

    <footer>
      <div class="text-center">
        <div class="row top">Contact Us</div>
        <div class="row bottom">copyrights &copy; HardWhereSoft</div>
      </div>

    </footer>
  </div>
</body>
</html>
