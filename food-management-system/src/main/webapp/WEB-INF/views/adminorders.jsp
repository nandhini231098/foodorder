<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Order List</title>
  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
 <link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
 <link href="/resources/css/imaging.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<center>    
<div class="topnav">
<security:authorize access="hasAnyRole('ADMIN')">
 <a href="/admin/additem">Add Item</a>
    <a href="/admin/items/1"> View Items</a>  
  <a href="/admin/list/1">Customers</a>
 <a href="/admin/viewcustomer">Feedbacks</a>  
  <div class="topnav-right">   
   <a href="/logout">Logout</a>
</security:authorize> 
</div>
</div>
<table class="table table-striped">
 
   <tr>
   <thead>   
    <th scope="row"> OrderNo</th>   
    <th scope="row"> ItemNames</th>    
    <th scope="row">price</th>
    <th scope="row">Quantity </th>    
   </thead>
   </tr>
   
     <c:forEach items="${adminOrder}" var="items" >
       <tr>
    <td>${items.orderno }</td>    
      <td>${items.itemName }</td>      
      <td>${items.price }</td> 
      <td>${items.quantity}</td>  
       <td>     
       <a class="btn btn-primary" href="/admin/feedback/${items.orderno}"  role="button" >View Feedback</a>    

      </td> 
        </tr>       
        
     </c:forEach>   
    
  </table>
  <center>
 <a class="btn btn-primary" href="/admin/viewcustomer"  role="button" >Back</a>    
   </center>           
  <div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>
</html>