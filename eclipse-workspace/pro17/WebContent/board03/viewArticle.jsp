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
	<form action="frmArticle" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td width="20%" align="center" bgcolor="#ff9933">글제목</td>
				<td><input type="text" value="${article.title }" name="title"
					id="i_title" disabled="disabled"></td>
			</tr>
			<tr>
				<td width="20%" align="center" bgcolor="#ff9933">글내용</td>
				<td><textarea rows="20" cols="60" id="i_content"
						disabled="disabled">${article.content }</textarea></td>
			</tr>

			<c:if
				test="${not empty article.imageFileName && article.imageFileName !='null' }">
				<tr>
					<td width="20%" align="center" bgcolor="#ff9933" rowspan="2">이미지</td>
					<td><img
						src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNO=${article.articleNO }"
						id="preview" /><br></td>
				</tr>
				<tr>
					<td><input type="file" name="imageFileName "
						id="i_imageFileName" disabled onchange="readURL(this);" /></td>
				</tr>
			</c:if>
		</table>

	</form>
</body>
</html>