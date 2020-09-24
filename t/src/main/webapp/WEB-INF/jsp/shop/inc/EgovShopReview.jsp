<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%-- <%@ page import ="egovframework.com.cmm.LoginVO" %> --%>
<%@ page import="egovframework.let.shop.review.service.ReviewVO"%>
<%@ include file="../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
<div class="container text-center">
	<h1>판매자 관리 리뷰입니다.</h1>
	<button id="#" name="buy">구매자 관리 리뷰입니다.</button>
	<button id="#" name="Update">수정</button>
	<button id="#" name="Delete">삭제</button>
</div>
<c:forEach items="${list}" var="result">
<div class="container text-center">
			<div class="row justify-content-center">
	<table border="1">
		<th>판매자아이디</th>
		<th>구매자 아이디</th>
		<th>리뷰 번호</th>
		<th>상품 번호</th>
		<th>상품 후기</th>
		<th>후기 등록일자</th>
		<th>판매자 평점</th>
		<tr>
			<td>${result.s_id }</td>
			<td>${result.sns_idx }</td>
			<td>${result.r_idx }</td>
			<td>${result.p_idx }</td>
			<td>${result.r_content }</td>
			<td>${result.r_regdate }</td>
			<td>${result.sns_score }</td>
		</tr>
	</table>
	</div>
</div>
</c:forEach> 
</body>
</html>