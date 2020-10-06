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
<title>회원 로그 페이지</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	<form action="/shop/mng/log/EgovMngLogList.do">
	<table border="soild">
		<tr>
			<th>등록 번호</th>
			<th>판매자 아이디</th>
			<th>구매자 아이디</th>
			<th>운영자 아이디</th>
			<th>IP 주소</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list }" var="log_list" varStatus="status">
			<tr>
				<td>${log_list.log_idx }</td>
				<td>${log_list.s_id }</td>
				<td>${log_list.sns_idx }</td>
				<td>${log_list.a_id }</td>
				<td>${log_list.log_ip }</td>
				<td>${log_list.log_date }</td>
			</tr>
		</c:forEach>
		</table>
		</form>
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>