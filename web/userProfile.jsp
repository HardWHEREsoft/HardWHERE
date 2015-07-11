<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.mongodb.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Ehelepola
  Date: 05/07/2015
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <%

    MongoClient mongo = new MongoClient( "localhost" , 27017 );
    //Connect to database
    DB db = mongo.getDB("consumerGoods");

    //Update Database
    DBCollection collection = db.getCollection("user");

    BasicDBObject whereQuery = new BasicDBObject();
    whereQuery.put("name", "Tharinda");
    DBCursor cursor = collection.find(whereQuery);
    while(cursor.hasNext()) {
      System.out.println(cursor.next());
    }

  %>
<head>
    <title>User Profile</title>
</head>
<body>



</body>
</html>
