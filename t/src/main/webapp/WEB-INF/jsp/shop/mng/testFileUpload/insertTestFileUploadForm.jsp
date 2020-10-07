<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	<div class="container">
		<div class="row">
			<form action="/shop/mng/testFileUpload/insertTestFileUploadPro.do"
				method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<th>파일 업로드</th>
						<td><input type="file" name="file"></td>
						<td><input type="submit" value="업로드"></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="row">
		<table>
		<c:forEach var="filelist" items="${list }">
		<tr>
			<td><img src="<c:url value='/'/>file/${filelist.stored_file_name}" width="200" height="150" /></td>
			<td>${filelist.tfile_idx }</td>
			<td>${filelist.original_file_name }</td>
			<td>${filelist.stored_file_name }</td>
			<td><button class="btn btn-danger" onclick="delFile(${filelist.tfile_idx })"></button></td>
		</tr>		
		
		</c:forEach>
		</table>
		</div>
	</div>

	<form name="frmDel" action="/shop/mng/testFileUpload/deleteTestFileUpload.do">
	<input type="hidden" name="tfile_idx" value="0"/>
	</form>
	
	<script type="text/javascript">
	function delFile(idx){
		alert("delFile idx : " + idx);
		document.frmDel.tfile_idx.value = idx;
		document.frmDel.submit();
	}
	</script>


	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>