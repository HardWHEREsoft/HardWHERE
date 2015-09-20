<%@ page import="com.hardwhere.model.MessageDetails" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mongodb.BasicDBList" %>
<%@ page import="com.hardwhere.controller.servlets.UserMessages" %>
<%--
  Created by IntelliJ IDEA.
  User: Ehelepola
  Date: 08/07/2015
  Time: 03:36
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
    <h1 class="col-md-6"><a href="index.jsp"> HardWHERE.lk</a></h1>
  </div>
</nav>

<!--Messaging Section-->
<section class="div_padding">
  <div class="container">
    <div class="row"><h3>My Messages</h3><hr style="height: 12px  border: 0  box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5)"></div>
    <div class="row">
      <div class="col-md-8 col-lg-offset2">
        <table class="table table-hover">
          <tbody>
          <%
            ArrayList<MessageDetails> messageList=new ArrayList<MessageDetails>();
            messageList=new UserMessages().getMessages(request.getParameter("shopName"));
            for(int i=0;i<messageList.size();i++){


              out.println("<div class=\"row\"><h4>"+messageList.get(i).getName()+"</h4></div>");
              BasicDBList list=messageList.get(i).getMessageList();
              for(int j=0;j<list.size();j++){

                out.println("<div class=\"row\"><p>"+list.get(j)+"</p></div>");
              }
              out.println("<div class=\"row\">");
              out.println("<form method=\"get\" action=\"sendMessage\" class=\"form-group\">");

              out.println("<div class=\"row text-right\" style=\"padding-top: 15px\">");
              out.println("<div class=\"row\"><input type=\"text\" class=\"form-control\" name=\"message\" rows=\"3\" spellcheck=\"true\" placeholder=\"Reply\">");
              out.println("<input type=\"submit\" class=\"btn btn-defaul\" value=\"reply\">");
              out.println("<input type=\"hidden\" name=\"address\" value="+"\""+messageList.get(i).getAddress()+"\""+">");
              out.println("<input type=\"hidden\" name=\"applicationID\" value="+"\""+messageList.get(i).getAppID()+"\""+">");
              out.println("</div>");
              out.println("</form>");
              out.println("</div>");
              out.println("</tr>");


            }
          %>
          <hr>
          </tbody>

        </table>
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