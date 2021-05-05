<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Admin View</title>
    </head>
    <body>
    
		<%
		 java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
		 list.add(1);
		 list.add(3);
		 list.add(5);
		 request.setAttribute("list", list);
		%>
		
		<h1>Liste meilleurs étudiants </h1>
			<ul>
			 	<c:forEach items="${list}" var="value">
					<li><c:out value="${value}"/>	</li>
			 	</c:forEach>
			</ul>
    </body>
</html>