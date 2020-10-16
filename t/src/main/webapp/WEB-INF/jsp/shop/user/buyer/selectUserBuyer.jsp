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

	<div class="container-fluid">
		<div class="row">
			<div class="mx-auto p-2">
				<button class="btn btn-outline-danger"
						onclick="location.href='/shop/user/buyer/updateUserBuyerForm.do'">
						정보수정</button>
				<button class="btn btn-outline-danger"
						onclick="location.href='/shop/user/basket/listBasketUser.do'">
						장바구니</button>
				<button class="btn btn-outline-danger"
						onclick="location.href='/shop/user/deal/dealUserBuyerList.do'">
						내 거래 보기</button>
				<button class="btn btn-outline-danger" onclick="location.href='/shop/user/like/LikeUserList.do'">찜한상품</button>
			</div>
		</div>
		<div class="row px-md-5">
			<div class="mx-auto">
			<h3 class="m-3"><b> ${BuyerVO.nickname } 님 안녕하세요! </b> </h3>
			<p class="m-3">${BuyerVO.nickname } 님은 ${BuyerVO.snscode } 계정으로 로그인 중이십니다. </p>
			</div>
		</div>
	</div>

	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>