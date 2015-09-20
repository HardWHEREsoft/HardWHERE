<%-- 
    Document   : index
    Created on : Jul 7, 2015, 10:37:53 PM
    Author     : Irunika Lakmal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/typeahead.bundle.js"></script>
        <script type="text/javascript" src="js/animation.js"></script>
        <title>Registration</title>
    </head>

<body>

   <nav class="navbar navbar-default">
        <div class="container-fluid">
            <h1 class="col-md-6"><a href="index.jsp"> HardWHERE.lk</a></h1>


        </div><!-- /.navbar-collapse -->
    </nav>


    <section class="div_padding">
    <div class="container">
        <h1 class="row">Registration </h1>
          <div class="row">
                     <table class="table table-deafult">
                         <form name="form1" action="register" method="POST" class="form-control">
                             <tr><td>Name: </td><td><input type="text" class="form-group" name="name" value="" size="100" /></td></tr>
                             <tr><td>Address1: </td><td><input type="text"  class="form-group" name="address1" value="" size="100" /></td></tr>
                             <tr><td>Address2: </td><td><input type="text"  class="form-group" name="address2" value="" size="100" /></td></tr>
                             <tr><td>Address3: </td><td><input type="text"  class="form-group" name="address3" value="" size="100" /></td></tr>
                             <tr><td>NIC No: </td><td><input type="text"  class="form-group" name="nic" value="" size="100" /></td></tr>
                             <tr><td>District: </td><td><input type="text"  class="form-group" name="district" value="" size="100" /></td></tr>
                             <tr><td>Postal Code: </td><td><input type="text"  class="form-group" name="postal" value="" id="postcode"></td></tr>
                             <tr><td>Tel: </td><td><input type="text" name="tel"  class="form-group" value="" size="100" /></td></tr>
                             <tr><td>Email: </td><td><input type="text"  class="form-group" name="email" value="" size="100" /></td></tr>
                             <tr><td><div style="color: #FF0000;">${errorMessage1}</div></td></tr>
                             <tr><td>User Name: </td><td><input type="text"  class="form-group" name="username" value="" size="20" /></td></tr>
                             <tr><td>Password: </td><td><input type="password"  class="form-group" name="password" value="" size="20" /></td></tr>
                             <tr><td><input class="btn btn-default" type="submit"  class="form-group" value="Submit" name="submit" /></td></tr>
                         </form>
                     </table>
                

        </div>
    </div>
    </section>
    
         <footer class="row">
            <div class=" text-center">
                <div class="row top">Contact Us</div>
                <div class="row bottom">copyrights &copy; HardWhereSoft</div>
            </div>

        </footer>
</body>
</html>
