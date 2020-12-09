<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Order List</title>
  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
 <link href="/resources/css/imaging.css" rel="stylesheet" type="text/css"/>
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="topnav">
 <security:authorize access="hasAnyRole('USER')">
 <div class="topnav-center">
   <p> Your Profile </p>
   </div>	
    <div class="topnav-right">
    
      <a href="/home">Back To Home</a>    
	</div>
	  </security:authorize> 
</div>
   <table class="table table-striped">
  
     <c:forEach items="${profileForm}" var="items" >     
       
    <tr>  <td>Your Name:${items.name }</td> </tr>     
      
     <tr>   <td>Location:${items.location }</td></tr>
     <tr>   <td> Phone Number:${items.phone }</td> </tr>
      <tr>   <td> Mail Id:${items.email}</td> 
      </tr>
      <tr>
      
     <td>
     <center>
    
       <a class="btn btn-primary" href="/user/updatecustomers/${items.id }" role="button">Edit</a>
       
         <a class="btn btn-primary" href="/user/vieworder" role="button">Your Orders</a>
       </center></td>
      
      </tr>
    </c:forEach>     
     
  </table>
  <div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>
</html>

