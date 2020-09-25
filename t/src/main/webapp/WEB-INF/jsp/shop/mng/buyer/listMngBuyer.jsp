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
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>

<body>
	<table class="table">
		<tr>
			<th>SNS 번호</th>
			<th>유저 아이디</th>
			<th>SNS 코드</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>등록일자</th>
			<th>상태</th>
			<th>상태 변경</th>
		</tr>
		<c:forEach items="${list }" var="sns_list">
			<tr>
				<td><a href="/shop/mng/buyer/updateMngBuyerForm.do?sns_idx=${sns_list.sns_idx }">${sns_list.sns_idx }</a></td>
				<td>${sns_list.userid }</td>
				<td>${sns_list.snscode }</td>
				<td>${sns_list.nickname }</td>
				<td>${sns_list.email }</td>
				<td>${sns_list.reg_date }</td>
				<td>${sns_list.del_yn }</td>
				<td><input type="button" value="전환" onclick="location.href='/shop/mng/buyer/updateMngBuyerStateChange.do?sns_idx=${sns_list.sns_idx }'" /></td>
			</tr>
		</c:forEach>
	</table>
		<div id="paging_div">
		<ul class="paging_align">	
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_productList" />
		</ul>
	</div>

</body>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>