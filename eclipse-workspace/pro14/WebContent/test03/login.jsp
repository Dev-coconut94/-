<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���â</title>
</head>
<body>
	<form action="result.jsp">
		���̵� : <input type="text" size="20"><br>
		��й�ȣ : <input type="password" size="20"><br>
		<input type="submit" value="�α���">
		<input type="reset" value="�ٽ��Է�">
	</form>
	<br><br>
	<%--
	<a href="${pageContext.request.contextPath}/memberForm.jsp">ȸ�������ϱ�</a>
	 --%>
	 <a href="${contextPath }/test03/memberForm.jsp">ȸ�������ϱ�</a>
</body>
</html>