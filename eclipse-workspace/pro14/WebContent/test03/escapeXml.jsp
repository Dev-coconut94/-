<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    
    %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>escapeXml 변환하기</h2>
	<h2>
		<pre>
			<c:out value="&lt;" escapeXml="true"></c:out>
			<c:out value="&lt;" escapeXml="false"></c:out>
			<c:out value="&gt;" escapeXml="true"></c:out>
			<c:out value="&gt;" escapeXml="false"></c:out>
			<c:out value="&amp;" escapeXml="true"></c:out>
			<c:out value="&amp;" escapeXml="false"></c:out>
			<c:out value="&#039;" escapeXml="true"></c:out>
			<c:out value="&#039;" escapeXml="false"></c:out>
			<c:out value="&#034;" escapeXml="true"></c:out>
			<c:out value="&#034;" escapeXml="false"></c:out>
		</pre>
	</h2>
</body>
</html>