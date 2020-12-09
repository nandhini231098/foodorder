<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>     
<html>
<head>

 <title>Customer List</title>
  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
   <link href="/resources/css/imaging.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="topnav">

<security:authorize access="hasAnyRole('ADMIN')">
 <a href="/admin/additem">Add Item</a>
   <a href="/admin/items/1">View Items</a>  
  <a href="/admin/list/1">Customers</a>
   <a href="/admin/viewcustomer">Feedbacks</a>  
  <div class="topnav-right">
   <a href="/logout">Logout</a>
</security:authorize> 
</div>
</div>
 <div class="container">
  <h2> Customer List</h2>
  <table class="table table-striped">
   <thead>
    <th scope="row">ID</th>
    <th scope="row">Name</th>
    <th scope="row">Location</th>   
   </thead>
   <tbody>
    <c:forEach items="${adminCustomer }" var="customer" >
     <tr>
      <td>${customer.id }</td>
      <td>${customer.name }</td>
      <td>${customer.location }</td>  
      <td>     
       <a class="btn btn-primary" href="/admin/vieworder/${customer.id }"  role="button" >View Order</a>    

      </td>       
     </tr>
    </c:forEach>
   </tbody>
  </table>
  
  
  
 
 
 </div>
 <div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>
</html>