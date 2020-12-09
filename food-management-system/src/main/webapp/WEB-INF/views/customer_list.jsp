<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>     
<html>
<head>
 <link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
 <title>Customer List</title>
  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
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
    <th scope="row">e-mail</th>
    <th scope="row">Phone Number</th>
   
   </thead>
   <tbody>
    <c:forEach items="${customerList }" var="customer" >
     <tr>
      <td>${customer.id }</td>
      <td>${customer.name }</td>
      <td>${customer.location }</td>
       <td>${customer.phone }</td>
        <td>${customer.email }</td>    
     </tr>
    </c:forEach>
   </tbody>
  </table>
  
  
  

 
 </div>
</body>
</html>