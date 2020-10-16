<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
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
	<form>
		<table class="table">
			<tr>
				<th>공지번호</th>
				<th>구분</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
			</tr>
			<c:forEach items="${list }" var="notice_list" varStatus="status">
				<tr>
					<td>${notice_list.n_idx }</td>
					<td>${notice_list.n_div }</td>
					<td>${notice_list.n_sub }</td>
					<td>${notice_list.n_content }</td>
					<td>${notice_list.n_date }</td>
				</tr>
			</c:forEach>
		</table>
		<!-- <input type="button" value="입력" onclick="location.href='/shop/mng/notice/insertMngNoticeForm.do'">
		<input type="button" value="수정" onclick="location.href='/shop/mng/notice/updateMngNoticeForm.do'">
		<input type="button" value="삭제" onclick="location.href='/shop/mng/notice/insertMngNoticeForm.do'"> -->
	</form>
			<div id="paging_div">
		<form name="frmPage" id="frmPage" action="/shop/mng/notice/listMngNotice.do">
			<ul class="paging_align">	
				<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
			</ul>
			<input type="hidden" name="searchWrd" value="${searchVO.searchWrd }" />
		</form>
	</div>
	
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>