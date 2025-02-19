<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="java.util.*,sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- c:set이 없어서 contextpath가 정상경로로 인식을 못하는 문제였다. -->
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력창</title>
<style type="text/css">
.cls1 {
	font-size: 40px;
	text-align: center;
}

.cls2 {
	font-size: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<p class="cls1">회원정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
		</tr>
	

	<c:choose>
		<c:when test="${membersList== null }">
			<tr>
				<td colspan="5">
					<b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
		</c:when>
		<c:when test="${membersList !=null }">
			<c:forEach var="mem" items="${membersList }">
				<tr align="center">
					<td>${mem.id }</td>
					<td>${mem.pwd }</td>
					<td>${mem.name }</td>
					<td>${mem.email }</td>
					<td>${mem.joinDate }</td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
	</table>
	<a href="${contextPath}/member/memberForm.do">
		<p class="cls2">회원가입하기</p>
	</a>
</body>
</html>