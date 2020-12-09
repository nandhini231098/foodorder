<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
 

<html>
<head>

  <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
 <link href="/resources/css/imaging.css" rel="stylesheet" type="text/css"/>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
  <title>Customer List</title>
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
 <div class="container">
  <h2> Items </h2> 
    <table class="table table-striped">
   <thead>
   <th scope="row">Item Id</th>
    <th scope="row">Item</th>   
    <th scope="row">price</th>
   </thead>
   <tbody>
  
   <c:forEach items="${itemList}" var="items" >
     <tr>
      <td>${items.itemId }</td>
      <td>${items.itemName}</td>
      <td>${items.price }</td>    
    
        <td>
 	 <a class="btn btn-primary" button type="submit" href="/user/carts?itemid=${items.itemId}" onclick="showalert()" role="button" >Add to cart</a>
     <script type="text/javascript">
   function showalert() {
  alert("Item added to cart!");
  }
</script>
      </td>   
    
     </tr>
    </c:forEach>
   </tbody>
  </table>
   
  </form:form>
  <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" href="/user/items/1">1</a></li>
                <li class="page-item"><a class="page-link" href="/user/items/2">2</a></li>
               <li class="page-item"><a class="page-link" href="/user/items/3">3</a></li>
              </ul>
 
<a class="btn btn-primary" button type="submit" href="/user/viewcart" role="button" >view cart</a>
 
 </div>
 </div>
<div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>
</html>