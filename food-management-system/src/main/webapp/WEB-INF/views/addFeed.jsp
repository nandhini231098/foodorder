<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Feedback Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="topnav">
  <a href="/home">Home</a> 

    <div class="topnav-right"> 	
     <a href="/logout">Logout</a>       
   </div> 

</div>
 <div class="container">
  <spring:url value="/user/savefeed" var="saveURL" />
  <h2>Your FeedBack</h2>
  <form:form modelAttribute="feedForm" method="post" action="/user/savefeed" cssClass="form" > 
   <div class="form-group">
    <label>FeedBack</label>
    <br>
  <textarea name="feedback" id="feedback" ></textarea>
   </div>   
   
   
   
   <button type="submit" class="btn btn-primary" onclick="showalert()">Submit</button>
   <script type="text/javascript">
   		function showalert() {
 		 alert("Feedback Submitted");
 			 }
		</script>
  </form:form>
  
  
  
 </div>
</body>
</html>