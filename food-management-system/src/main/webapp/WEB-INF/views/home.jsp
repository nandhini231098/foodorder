<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/imaging.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="auth">
<security:authorize access="isAuthenticated()">
    Welcome <security:authentication property="principal.username" /> 
</security:authorize>
</div>
<div class="topnav">

<security:authorize access="hasAnyRole('USER')">
 <a href="/user/items/1">Items</a>
      <a href="/user/viewcart">MyCart</a>  
  
    <div class="topnav-right">
  	<a href="/user/profile">Account</a> 	
     <a href="/logout">Logout</a>    
</security:authorize>

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
<h1>  welcome to food order </h1>
<div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>
</html>