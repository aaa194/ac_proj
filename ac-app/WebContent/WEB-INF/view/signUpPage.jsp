<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

	<title>SignUp Page</title>
	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Welcome, please fill the form.</h2>
		</div>
	</div>
	
	<div>
		<h3>Form</h3>
		
		<form action="signUpUser" modelAttribute="user" method="POST">
		
			<table>
			
				<tbody>
				
				<tr>
					<td><label>First name:</label></td>
					<td><input name="firstName" type="text" required/></td>
				</tr>
				
				<tr>
					<td><label>Last name:</label></td>
					<td><input name="lastName" type="text" required/></td>
				</tr>
				
				<tr>
					<td><label>Email:</label></td>
					<td><input name="email" type="text" required/></td>
				</tr>
				
				<tr>
					<td><label>Password:</label></td>
					<td><input name="password" type="text" required/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
				
				
				</tbody>
			
			</table>
		
		</form>
		
		<div style="clear; both;"></div>
		<p>
			Already have an account?<a href="${pageContext.request.contextPath}/user/login">Back to login</a>
		</p>
	</div>
	
	
</body>

</html>