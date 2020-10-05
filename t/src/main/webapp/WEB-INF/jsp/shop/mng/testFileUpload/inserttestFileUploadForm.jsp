<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<form action="/shop/mng/testFileUpload/inserttestFileUploadPro.do" method="post" enctype="multipart/form-data">
<div class="container">
	<div class="row">
		<table>
			<tr>
				<th>파일 업로드</th>
				<td><input type="file" name="file"></td>
				<td><input type="submit" value="업로드"></td>
			</tr>
		</table>
	</div>
</div>
</form>



  
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>