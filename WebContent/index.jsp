<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts - Demo - Stored Procedure In Hibernate</title>
</head>
<body>

	<a href="addnew.html">Add New</a> |
	<a href="search.html">Search</a>
	
	<h1>List Books:</h1>
	
	<table border="1px solid black">
	
		<tr>
			<th>ID</th>
			<th>Book Name</th>
			<th>Price</th>
			<th>Publish</th>
			<th>Option</th>
		</tr>
		
		<c:forEach var="book" items="${lstBooks }">
		
			<tr>
				<td>${book.bookId }</td>
				<td>${book.bookName }</td>
				<td>${book.bookPrice }</td>
				
				<td><fmt:formatDate value="${book.publish }" var="bookPublish"
						pattern="yyyy-MM-dd" /> ${bookPublish }</td>
				<td><s:url var="updateURL" value="update.html">
						<s:param name="bookID">${book.bookId }</s:param>
					</s:url> <s:a href="%{updateURL}">Update</s:a> | <s:url var="deleteURL"
						value="delete.html">
						<s:param name="bookID">${book.bookId }</s:param>
					</s:url> <s:a href="%{deleteURL}"
						onclick="return confirm('Do you want to delete?')">Delete</s:a></td>
						
			</tr>
		</c:forEach>
	</table>
</body>
</html>