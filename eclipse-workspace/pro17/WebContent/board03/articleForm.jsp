<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set value="${pageContext.request.contextPath }" var="contextPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);

			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}
</script>



<title>새글 쓰기창</title>
</head>
<body>
	<h1 style="text-align: center;">새 글 쓰기</h1>
	<form action="${contextPath }/board/addArticle.do" name="articleForm"
		method="post" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td align="right">글제목:</td>
				<td colspan="2"><input type="text" size="67" maxlength="500"
					name="title"></td>
			</tr>
			<tr>
				<td align="right" valign="top">글내용:</td>
				<td colspan="2"><textarea rows="10" cols="65" maxlength="4000"
						name="content"></textarea></td>
			</tr>
			<tr>
				<td align="right">이미지파일 첨부:</td>
				<td><input type="file" name="imageFileName"
					onchange="readURL(this);" /></td>
				<td><img id="preview" src="#" width="200" height="200" /></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2"><input type="submit" value="글쓰기" /> <input
					type=button value="목록보기" onclick="backToList(this.form)" /></td>
			</tr>


		</table>

	</form>
</body>
</html>