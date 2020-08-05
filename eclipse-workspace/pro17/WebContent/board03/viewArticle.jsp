<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td width="20%" align="center" bgcolor="#ff9933">글제목</td>
		<td>
			<input type="text" value="${article.title }" name="title" id="i_title" disabled="disabled">
		</td>
	</tr>
	<tr>
		<td width="20%" align="center" bgcolor="#ff9933">글내용</td>
		<td>
			<text
		</td>
	</tr>
</table>
</body>
</html>