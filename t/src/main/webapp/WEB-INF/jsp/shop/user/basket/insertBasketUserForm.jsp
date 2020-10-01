<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

	${msg }
	<form action="/shop/user/basket/insertBasketUserPro.do" method="post">

		<table class="table">
			<tr>
				<th>상품번호</th>
				<td><input type="text" name="p_idx" /></td>
			</tr>
			<tr>
				<th>판매자 아이디</th>
				<td><input type="text" name="s_id" /></td>
			</tr>
			<tr>
				<th>상품 수량</th>
				<td><input type="text" name="ba_q" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="확인" /></td>
			</tr>
		</table>
	</form>


	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>