<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts - Demo - Stored Procedure In Hibernate</title>
</head>
<body>
	<h1>Add New:</h1>
	<form action="process-addnew.html" method="post">
		<table>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="book.bookName"></td>
			</tr>
			<tr>
				<td>Book Price:</td>
				<td><input type="text" name="book.bookPrice"></td>
			</tr>
			<tr>
				<td>Publish:</td>
				<td><input type="text" name="publish"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add New"></td>
			</tr>
		</table>
	</form>
	<%
		String message = (String) request.getAttribute("message");
		if(!(message == null)){
			out.println(message);
		}else{
			message = "";
			out.println(message);
		}
	%>
</body>
</html>