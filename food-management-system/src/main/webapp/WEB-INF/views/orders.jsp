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

    <div class="topnav-center">
       <p> Your Orders </p>
       </div>
       <div class="topnav-right">    
      <a href="/home">Back To Home</a>    
	</div>
       </div>
        </center>
   <table class="table table-striped">
 
   <tr>
   <thead>   
    <th scope="row"> Orderno</th>    
    <th scope="row"> ItemName</th>    
    <th scope="row">price</th>
    <th scope="row">Quantity </th> 
    
   </thead>
   </tr>
   <c:set var="total" value="${0}" /> 
     <c:forEach items="${orderForms}" var="items" >
            <tr>
    <td>${items.orderno }</td>  
      <td>${items.itemName }</td>      
      <td>${items.price }</td> 
      <td>${items.quantity}</td> 
      <td> <fmt:formatDate value="${items.updatedDate}" pattern="dd MMM yyyy" /></td>
      
      
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