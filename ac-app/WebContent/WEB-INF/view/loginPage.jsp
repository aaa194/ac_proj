<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Demo with JSP</title>
        
        <style>
        	.body{
        		background-color: lightblue; 
        		}
			.form {
  				font-family: verdana;
  				font-size: 110%;
  				size: 140%
				}
			 .p	{
  				color: red;
  				font-family: courier;
  				font-size: 130%;
				}
			.button {
  				background-color: #4CAF50; /* Green */
  				border: none;
  				color: white;
  				padding: 20px;
  				text-align: center;
  				text-decoration: none;
  				display: inline-block;
  				font-size: 16px;
 				margin: 4px 2px;
  				cursor: pointer;
  				border-radius: 8px;
}
		</style>
        
    </head>
    <body class="body">
        <form method="get" action="loginUser" modelAttribute="user">
            <center>
            <table border="1" cellpadding="5" cellspacing="2">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" required/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Login" class="button" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" class="button" />
                        </td>                        
                    </tr>                    
                </tbody>
            </table>
            </center>
        </form>
        
        <div style="clear; both;"></div>
		<p>
			Not sign up yet? <a href="${pageContext.request.contextPath}/user/signUpPage">SIGN UP HERE!</a>
		</p>
        
    </body>
</html>