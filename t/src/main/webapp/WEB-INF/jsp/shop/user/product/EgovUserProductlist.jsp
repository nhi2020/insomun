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
<title>유저용 상품 관리 페이지입니다</title>

</head>

<body>

	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	<c:if test="${msg != null}">
		<h1>${msg}</h1>
	</c:if>

	
	
	
<form action="/shop/user/product/EgovUserProductDelete.do">
<c:if test="${sessionScope.status == 2 }">
<input type="button" value="등록" onclick="location.href='/shop/user/product/EgovUserProductInsertForm.do'" style="float:right"> &nbsp;
<input type="submit" value="삭제" style="text-align: center";>

</c:if>
<c:if test="${sessionScope.status == 1 }">
<input type="submit" value="거래하기" onclick="">
</c:if>
 <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
	  		<c:forEach var="productuser_list" items="${list}">
			<div class="col-3">
					
					<a href="/shop/user/product/EgovBuyerProductForm.do?p_idx=${productuser_list.p_idx }">
					<img src="./images/main/photo/${productuser_list.p_image}" width="270" height="270"></a>
					<span >
					<input type="checkbox" name="check" id="check" value="${productuser_list.p_idx }">
					상품명: ${productuser_list.p_name }</span>
					<br/><span >가격: ${productuser_list.p_price }</span>
					<br/><span >상태: ${productuser_list.p_status }</span>
					<br/><span >재고 수량: ${productuser_list.p_q }</span>
					<br/><span >업데이트된 날짜: ${productuser_list.p_moddate }</span>
					<c:if test="${sessionScope.status == 2 }">
					<input type="button" value="수정" onclick="location.href='/shop/user/product/EgovUserProductUpdateForm.do?p_idx=${productuser_list.p_idx}'" >
					</c:if>

				</p>				
			</div>
			
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>