<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<script type="text/javascript">
</script>
</head>
<body>
	<%@ include file="../inc/EgovShopHeader.jsp"%>
	<!-- 테스트용 임시 링크 -->
	<div class="container text-center">
		<div class="row justify-content-center">
			<table border="1">
				<tr>
					<td><a href="/shop/mng/buyer/listMngBuyer.do">구매자 관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/user/review/reviewList.do">리뷰 페이지</a></td>
				</tr>
				<tr>
					<td><a href="/shop/mng/review.do">판매자 리뷰 관리</a></td>
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
					<td><a href="/shop/user/product/EgovUserProductlist.do">상품 관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/user/seller/sellerUserMain.do">판매자 페이지</a></td>
				</tr>
				<tr>
					<td><a href="/shop/mng/deal/dealMngList.do">운영자 거래관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/user/deal/dealUserBuyerList.do">구매자 거래관리</a></td>
				</tr>
				<tr>
					<td><a href="/shop/user/deal/dealUserSellerList.do">판매자 거래관리</a></td>
				</tr>
					<td><a href="#">### 관리</a></td>
				<tr>
					<td><a href="#">### 관리</a></td>
				</tr>
				<tr>
					<td><a href="#">### 관리</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- <div id="test">

</div> -->

	<div class="container text-center" style="position: relative;">

		<img src="<c:url value='/images/shop/main/main.jpg'/>" width=800
			height="450">
		<div
			style="left: 350px; width: 450px; bottom: 140px; font-size: 1.8em; font-weight: bold; position: absolute;">
			<h1>입소문넷</h1>
			믿음직한 농산품 직거래 입소문넷 입니다.

		</div>
	</div>




	<div class="container-fluid">
		<div class="container text-center">
			<h3>추천 상품</h3>
			<div class="row">
				<c:forEach var="product_list" items="${list}">
					<div class="col-3">

						<img src="./images/main/photo/${product_list.p_image}" width="270"
							height="385" />

						<p>

							<span>판매자 아이디: ${product_list.s_id }</span> <br /> <span>가격:
								${product_list.p_price }</span> <br /> <span>상태:
								${product_list.p_status }</span> <br /> <span>재고 수량:
								${product_list.p_q }</span> <br /> <span>업데이트된 날짜:
								${product_list.p_moddate }</span>
						</p>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>











	<%@ include file="../inc/EgovShopBottom.jsp"%>
</body>
</html>