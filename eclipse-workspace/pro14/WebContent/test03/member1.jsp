<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	request.setCharacterEncoding("utf-8");
%>

<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'ȫ�浿'}" scope="page" />
<c:set var="age" value="${22}" scope="page" />
<c:set var="height" value="${177}" scope="page" />


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ���â</title>
</head>
<body>
	<table align="center" border=1>
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>���̵�</b></td>
			<td width="7%"><b>��й�ȣ </b></td>
			<td width="7%"><b>�̸� </b></td>
			<td width="7%"><b>���� </b></td>
			<td width="7%"><b>Ű </b></td>
		</tr>
		<tr align="center" >
			<td >${id}</td>
			<td >${pwd}</td>
			<td >${name}</td>
			<td >${age}</td>
			<td >${height}</td>
		</tr>
	</table>
</body>
</html>