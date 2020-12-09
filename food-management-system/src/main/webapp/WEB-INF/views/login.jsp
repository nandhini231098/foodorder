
<html>

<head>
<link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
<link href="resources/css/imaging.css" rel="stylesheet" type="text/css"/>
</head>
<div class="images">
<body > 

<center>
    <h1>Login Form</h1>
 
    <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
 <div class="login">
    <form name='login' action="/login" method='POST'>
    <div class=container>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
       
            <tr>
                <td colspan='2'><input name="submit" type="submit" onclick="showalert()" value="submit" class="button1" /></td>
          <script type="text/javascript">
   		function showalert() {
 		 alert("Logged In Successfully");
 			 }
		</script>          
          
            </tr>
          
        </table>
         <br> <br>  <button type="submit" formaction="/logout" class="logout">Back</button>
        </div>
        </center>    
        
    </form>
    </div>
    
 <div class="footers">
 <center>
  <p>Hot& Spicy Food Order<br>
  </center>
</div>
</body>

</html>