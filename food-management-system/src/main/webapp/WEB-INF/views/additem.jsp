<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Add Item</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
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
  <spring:url value="/admin/saveitem" var="saveURL" />
  <h2>Add Item</h2>
  <form:form modelAttribute="itemForms" method="post" action="${saveURL }" cssClass="form" >
  
   
   <div class="form-group">
    <label>Item Name</label>
    <form:input path="itemName" cssClass="form-control"  />
   </div>
   
   <div class="form-group">
    <label>Price</label>
    <form:input path="price" cssClass="form-control" id="price" />
   </div>
   
   <button type="submit" class="btn btn-primary" onclick="showalert()">Add Item</button>
    <script type="text/javascript">
   		function showalert() {
 		 alert("Item Added");
 			 }
		</script>
  </form:form>
  
 </div>
</body>
</html>