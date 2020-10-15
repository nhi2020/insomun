
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
	<div class="container text-center" style="position: relative;">

		<img src="<c:url value='/images/shop/main/main.jpg'/>" width=100%
			height="450">
		<div
			style="left: 350px; width: 450px; bottom: 140px; font-size: 1.8em; font-weight: bold; position: absolute;">
			<h1>입소문넷</h1>
			믿음직한 농산품 직거래 <p>  
			입소문넷 입니다.

		</div>
	</div><br>

		<div class="container">
			<h3>추천 상품</h3>
			<div class = "mx-auto" style="height: auto; width: 100%; border-top:2px solid #cd3c3c;">
			<div class="container">
			<div class="row" style="background-color: #fff8f8; padding: 20px">
				<c:forEach var="productuser_list" items="${list}">
					<div class="col-3">
						<a href="/shop/user/product/EgovBuyerProductForm.do?p_idx=${productuser_list.p_idx }">
						<img src="<c:url value='/'/>file/${productuser_list.p_image}" width="200" height="200" class="rounded"/> </a><br>
						<input type="hidden" value="${productuser_list.p_idx }">
							 <span style="">${productuser_list.p_name }</span> 
							<br/> <span><fmt:formatNumber value="${productuser_list.p_price }" pattern="##,###"></fmt:formatNumber>원</span><br>
					</div>

				</c:forEach>
			</div>
			</div>
		</div>
	</div><Br><Br>
	<%@ include file="../inc/EgovShopBottom.jsp"%>
</body>
</html>