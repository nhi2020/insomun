<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ page import="egovframework.let.shop.mng.product.service.impl.ProductMngVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>운영자 상품 관리 페이지입니다</title>

</head>
<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>


<form action="/shop/mng/product/EgovMngProductDelete.do">
<input type="button" value="등록" onclick="location.href='/shop/mng/product/EgovMngProductInsertForm.do'"> &nbsp;
<input type="submit" value="삭제">
 <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
	  		<c:forEach var="product_list" items="${list}">
			<div class="col-3">
					
					<img src="./images/main/photo/${product_list.p_image}" width="270" height="270"/>
					
					<span>
					<input type="checkbox" name="check" id="check" value="${product_list.p_idx }">
					판매자 아이디: ${product_list.s_id }</span>
					<br/><span >상품명: ${productuser_list.p_name }</span>
					<br/><span >가격: ${product_list.p_price }</span>
					<br/><span >상태: ${product_list.p_status }</span>
					<br/><span >재고 수량: ${product_list.p_q }</span>
					<br/><span >업데이트된 날짜: ${product_list.p_moddate }</span>
					<input type="button" value="수정" onclick="location.href='/shop/mng/product/EgovMngProductUpdateForm.do?p_idx=${product_list.p_idx}'" >
					<%-- <c:if test=""></c:if> --%>
				</p>				
			</div>
			</c:forEach>
		</div>
	</div>
</div>
</form>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>