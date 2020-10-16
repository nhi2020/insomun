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
<style>
<!--

-->
</style>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<div class="container text-center">
		<div class="row justify-content-center">

	<h2 class="text-center mx-auto"><strong>Admin Page</strong></h2>
	<div class="text-center">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
		
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/product/EgovMngProductlist.do'">상품 관리</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/basket/listMngBasket.do'">장바구니 관리</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/buyer/listMngBuyer.do'">구매자 관리</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/seller/listMngSeller.do'">판매자 관리</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/admin/adminControl/listMngAdminControl.do'">운영자관리</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/log/EgovMngLogList.do'">로그 페이지</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/user/review/reviewList.do'">리뷰 페이지</button>
<button class="m-3 btn btn-outline-secondary" 
		onclick="location.href='/shop/mng/review.do'">관리자리뷰 관리</button>

			</div>
			<div class="col-4"></div>





		<!-- 	<img class="mx-auto" src="/images/shop/main/admin.png" usemap="#map" style="margin-bottom: 100px;"/>
			<map name="map" id="map">
		   <area shape="rect" href="memMng.do" 	 								coords="87,60,246,179" />
				<area shape="rect" href="/shop/mng/product/EgovMngProductlist" 	 			coords="391,105,561,224" />
				<area shape="rect" href="/shop/mng/review/MngSelect.do"   					coords="620,79,794,222" />
				<area shape="rect" href="/shop/mng/admin/adminControl/listMngAdminControl"  coords="169,294,319,444" />
				<area shape="rect" href="/shop/mng/seller/listMngSeller" 					coords="393,311,612,326" />
				<area shape="rect" href="/shop/mng/buyer/listMngBuyer" 	 					coords="631,308,800,450" />
			</map> -->
		</div>
	</div>

	</div></div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>