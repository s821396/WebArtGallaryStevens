<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action = "editArtServlet">
<table>
<c:forEach items ="${requestScope.allArt}" var="currentart">
<tr>
	<td><input type="radio" name="id" value="${currentart.id}"></td>
	<td>${currentart.title}</td>
	<td>${currentart.artistName}</td>
	<td>${currentart.media}</td>
	<td>${currentart.year}</td>
	<td>${currentart.value}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "Edit Selected Art" name = "doThisToArt">
<input type = "submit" value = "Delete Selected Art" name = "doThisToArt">
<input type = "submit" value = "Add New Art" name = "doThisToArt">
</form>
</body>
</html>