<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sms.sample.Items" %>
<%@ page import="com.sms.sample.Query" %>
<%--
  Created by IntelliJ IDEA.
  User: Ehelepola
  Date: 05/07/2015
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>consumerGoods</title>
  </head>
  <body>

    <form action="query" method="get">

      <textarea name="search" rows="1" cols="50" onkeyup="showSuggestion(this.value)" ></textarea>

      <input type="submit" value="search">

    </form>
    <p><b>Suggestions:</b> <span id="suggestions"></span></p>

  <div>
    <%
      ArrayList<Items> items;

      items=new Query().getItemsByrPrice(request.getParameter("search"));
      for(int i=0;i<items.size();i++){

        out.println("-------------------------------------<br>");
        out.println("name: "+items.get(i).getName());
        out.println("Shop name: "+items.get(i).getShopName());
        out.println("Contact: "+items.get(i).getContact());
        out.println("Description: "+items.get(i).getDescription());
        out.println("Image: "+items.get(i).getImage());
        out.println("Price: "+items.get(i).getPrice());
        out.println("District: "+items.get(i).getDistrict());
        out.println("-------------------------------------<br>");
      }

    %>


  </div>

  </body>
  <script>

    function showSuggestion(input)
    {
      if(input.length != 0) 	//if the input field is not empty
      {
        var xmlhttprequest = new XMLHttpRequest();
        xmlhttprequest.onreadystatechange = getServerResponse;
        xmlhttprequest.open('GET', 'getHint?userInput='+ input, true);
        xmlhttprequest.send();
        // send a GET request to the server. Send the user input as a parameter in the url. You have to use open() and send() methods here to send a request.

      }
      else
      {
        document.getElementById("suggestions").innerHTML = "";	//if the input field is empty, suggestion field should also be empty
        return;
      }

      function getServerResponse()
      {
        //checking the 'readyState' and 'status' properties of the XMLHttpRequest object, set the 'suggestions' field to the response received by the server.
        if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200)
        {
          document.getElementById("suggestions").innerHTML=xmlhttprequest.responseText;
        }
        else{
          document.getElementById("suggestions").innerHTML="Not Found";
        }
      }
    }

  </script>
</html>
