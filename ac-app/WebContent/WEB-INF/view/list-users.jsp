<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Users</title>
	
	<!-- reference our style sheet -->
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	
	
</head>

<body>
	
	<div id="wrapper">
	
		<div id="header">
			<h2>List of users</h2>
			<input  hidden="true" name = "senderId" value= "${user.id}">
		</div>
	
	</div>
	
	<div id="container">
		
		<div id="content">
		
		<!-- put new button ADD USER -->
		<input type="button" value="Add User" 
				onClick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
		/>
			
			<table>
				
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our users -->
				<c:forEach var="tempUser" items="${users}">
				
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>
				
					<tr>
					
						<td> ${tempUser.firstName} </td>
						<td> ${tempUser.lastName} </td>
						<td> ${tempUser.email} </td>
						
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>

						</td>
						
							
					</tr>
					
				</c:forEach>
			
			</table>
				
		</div>
		
	</div>
	
	
</body>

</html>