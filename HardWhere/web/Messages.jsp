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
<html>
<head>
  <title>Messages</title>
</head>

<body>

<%
  ArrayList<MessageDetails> messageList=new ArrayList<MessageDetails>();
  messageList=new UserMessages().getMessages(request.getParameter("shopName"));
  for(int i=0;i<messageList.size();i++){

    out.println("name:"+messageList.get(i).getName());
    out.println("<br>");
    out.println("address:"+messageList.get(i).getAddress());
    out.println("<br>");
    BasicDBList list=messageList.get(i).getMessageList();
    for(int j=0;j<list.size();j++){

      out.print(list.get(j));
      out.println("<br>");
    }
    out.println("<form action=\"sendMessage\" method=\"post\">");
    out.println("<textarea name=\"message\" rows=\"5\" cols=\"20\" ></textarea>");
    out.println("<input type=\"submit\" value=\"Submit\">");
    out.println("<input type=\"hidden\" name=\"address\" value="+messageList.get(i).getAddress()+">");
    out.println("<input type=\"hidden\" name=\"applicationID\" value="+messageList.get(i).getAppID()+">");
    out.println("</form>");
    out.println("<br>");
    out.println("<br>");
  }
%>




</body>
</html>