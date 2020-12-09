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
<div class="topnav">
 <security:authorize access="hasAnyRole('USER')">
 <a href="/home">Home</a>
 <a href="/user/items/1">Items</a>
<a href="/user/viewcart">MyCart</a> 
  
 
    <div class="topnav-right">
       	
     <a href="/logout">Logout</a>  
	</div>
	  </security:authorize> 

</div>
   <table class="table table-striped">
   
   <tr>
   <thead>   
    <th scope="row">Item ID</th>
    <th scope="row">Name</th>    
    <th scope="row">price</th>
     <th scope="row">Quantity</th>
    
   </thead>
   </tr>
   <c:set var="total" value="${0}" /> 
     <c:forEach items="${cartForms}" var="items" >     
       <tr>
      <td>${items.item.itemId }</td>
      <td>${items.itemname }</td>
      <td>${items.price }</td> 
       <td>${items.quantity}</td> 
       <td>     
       <a class="btn btn-primary" href="/user/deleteitem/${items.cartid}" onclick="showalert()" role="button" >Delete</a>
       <script type="text/javascript">
  		 function showalert() {
  		alert("Item deleted!");
 		 }
		</script>
      </td> 
      <td>     
       <a class="btn btn-primary" href="/user/updateQuantity/${items.cartid}"  role="button" >Edit Quantity</a>    

      </td> 
        <td> 
         <c:set var="total" value="${total + items.price * items.quantity}" />   </td>          
     </tr>       
    </c:forEach> 
    
     <tr>
   <td> Total:${total} </td>
   </tr> 
  </table>
  <center>
   <a class="btn btn-primary" href="/user/viewpayment"  role="button" >Proceed to payment</a>
   </center>
   <div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
   
</body>
</html>