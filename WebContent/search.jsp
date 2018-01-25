<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts - Demo - Stored Procedure In Hibernate</title>
</head>
<body>	
	<h1>Search Book:</h1>
	<form action="process-search.html" method="post">
		<table>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="bookName"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	<br><br>
	<table border="1px solid black">
		<tr>
			<th>ID</th>
			<th>Book Name</th>
			<th>Price</th>
			<th>Publish</th>
		</tr>
		<c:choose>
			<c:when test="${not empty lstBooks }">
				<c:forEach var="book" items="${lstBooks }">
					<tr>
						<td>${book.bookId }</td>
						<td>${book.bookName }</td>
						<td>${book.bookPrice }</td>
						<td>
							<fmt:formatDate value="${book.publish }" var="bookPublish" pattern="yyyy-MM-dd"/>
							${bookPublish }
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4"><% out.println("Data not found!"); %></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>