<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Article Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>

</head>
<body>
 <div class="container">
  
  <h2>Quantity</h2>
  <form:form modelAttribute="quantityForm" method="post" action="/user/savequantity" cssClass="form" >
  <div class="form-group">
    <label>cartId</label>
    <form:input path="cartid" cssClass="form-control" id="cartid"  />
   </div>
   <div class="form-group">
    <label>Quantity</label>
    <form:input path="quantity" cssClass="form-control" id="quantity"  />
   </div>
    <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
  
 </div>
</body>
</html>