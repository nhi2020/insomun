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

<form action="<c:url value='/shop/mng/admin/adminMainForm.do'/>">
	<h2 class="text-center" style="padding-bottom: 50px; margin-top: 50px;"><strong>Admin Page</strong></h2>
	<div class="text-center">
		<div class="row">
		<table border="1">
				<tr>
					<td><a href="/shop/mng/buyer/listMngBuyer.do">구매자 관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/user/review/reviewList.do">리뷰 페이지</a></td>
				</tr>
				<tr>
					<td><a href="/shop/mng/review/MngSelect.do">관리자리뷰 관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/mng/basket/listMngBasket.do">장바구니 관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/mng/seller/listMngSeller.do">판매자 관리</a></td>
				</tr>
				<tr>
					<td><a
						href="/shop/mng/admin/adminControl/listMngAdminControl.do">운영자관리</a>
				</tr>
				<tr>
					<td><a href="/shop/mng/product/EgovMngProductlist.do">상품 관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/user/seller/sellerUserMain.do">판매자 페이지</a></td>
				</tr>
				<tr>
					<td><a href="/shop/mng/log/EgovMngLogList.do">로그 페이지</a></td>
				</tr>
				<!-- <tr>
					<td><a href="#">### 관리</a></td>
				<tr>
					<td><a href="#">### 관리</a></td>
				</tr>
				<tr>
					<td><a href="#">### 관리</a></td>
				</tr> -->
			</table>
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
	</form>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>