<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
    

<html>
<head>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
  <title>Item List</title>
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
   </div>
</security:authorize> 
</div>
 <div class="container">
  <h2> Items</h2>    
   <form:form  method="post" action="" cssClass="form" >
    <table class="table table-striped">
   <thead>
   <th scope="row">Item Id</th>
    <th scope="row">Item</th>   
    <th scope="row">price</th>
   </thead>
   <tbody>
  
   <c:forEach items="${cartList}" var="items" >
     <tr>
      <td>${items.itemId }</td>
      <td>${items.itemName}</td>
      <td>${items.price }</td>    
    
        
     </tr>
    </c:forEach>
   </tbody>
  </table>
   
  </form:form>
  <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" href="/admin/items/1">1</a></li>
                <li class="page-item"><a class="page-link" href="/admin/items/2">2</a></li>
              
              </ul>
 

 
 </div>

</body>
</html>