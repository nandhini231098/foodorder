<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Payment List</title>
  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
  <link href="/resources/css/imaging.css" rel="stylesheet" type="text/css"/>
   <link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>  
</head>
<body>
<div class="topnav">
<a href="/home">Home</a>
 <a href="/user/items/1">Items</a>
 <a href="/user/viewcart">MyCart</a> 
    <div class="topnav-center">
       <p> Payment </p>
     </div>
    </div>
    <table class="table table-striped">   
   <tr>
   <thead>   
    <th scope="row">Name</th>    
    <th scope="row">price</th>
     <th scope="row">Quantity</th>
    
   </thead>
   </tr>
   <c:set var="total" value="${0}" /> 
        <c:forEach items="${paymentForms}" var="items" >     
       <tr>
   
      <td>${items.itemname }</td>
      <td>${items.price }</td> 
       <td>${items.quantity}</td> 
        <td> 
         <c:set var="total" value="${total + items.price * items.quantity}" />
            </td>  
             </c:forEach> 
    
     <tr>
   <td> Total:${total} </td>
   </tr> 
  </table>    
<center>
<table>
<tr>
    <td>  <input type="radio" value="" name="a">Credit card</td> </tr>
    <tr>
    <td>  <input type="radio" value="" name="a">Net banking <td> </tr>
    <tr>
       <td> <input type="radio" value="" name="a">UPI</td> </tr>
       <tr>
     <td>  <input type="radio" value="" name="a">Cash On delivery<td> 
     </tr>
     <tr>
     <td>  
     <a class="btn btn-primary"  onclick="showalert()" href="/user/order" role="button" >Pay</a>
       <script type="text/javascript">
   function showalert() {
  alert("Paid Succcessfully!");
  }
</script>
     </tr>
     
  </table>
  </center>

<div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>
</html>