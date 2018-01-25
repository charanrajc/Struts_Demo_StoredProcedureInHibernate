<%@page import="entities.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts - Demo - Stored Procedure In Hibernate</title>
</head>
<body>
	<h1>Update Book:</h1>
	<% Book book = (Book) request.getAttribute("book"); %>
	<form action="process-update.html" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="book.bookId" value="<%= book.getBookId() %>"></td>
			</tr>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="book.bookName" value="<%= book.getBookName() %>"></td>
			</tr>
			<tr>
				<td>Book Price:</td>
				<td><input type="text" name="book.bookPrice" value="<%= book.getBookPrice() %>"></td>
			</tr>
			<tr>
				<td>Publish:</td>
				<td>
					<fmt:formatDate value="<%= book.getPublish() %>" var="bookPublish" pattern="yyyy-MM-dd"/>
					<input type="text" name="publish" value="${bookPublish }">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
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