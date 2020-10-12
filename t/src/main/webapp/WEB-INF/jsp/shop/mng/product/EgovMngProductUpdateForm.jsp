<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ page import="egovframework.let.shop.mng.product.service.impl.ProductMngVO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>운영자 상품 리스트 수정</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<script type="text/javascript">
	function upload(p_idx) {
		document.frm.action = "/shop/user/basket/insertBasketUserPro.do";
		document.frm.submit();
	}
</script>
<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<h2>수정 2 페이지</h2>

	<c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
	
 <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
			<form action="/shop/mng/product/EgovMngProductUpdatePro.do" method="post" enctype="multipart/form-data">
	    			<input type="hidden" name="p_idx" value="${ProductMngVO.p_idx }" />
	    			<input type="hidden" name="preImage" value="${ProductMngVo.preImage }">
					<img src="<c:url value='/'/>file/${ProductMngVO.p_image}" width="270" height="270"/>
					<br/>
					<table class="table">
					<tr>
						<th>사진변경</th>
						<td><input type="file" name="file" value="${ProductMngVO.p_image}" />
						</td>
					</tr>
					<tr>
						<th>상품명</th>
						<td><input type="text" name="p_name" value="${ProductMngVO.p_name }"/>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="p_price" value="${ProductMngVO.p_price }"/></td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td>
						<textarea rows="5" cols="50" name="p_content" id="p_content">${ProductMngVO.p_content } </textarea></td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td><input type="text" name="p_tage" value="${ProductMngVO.p_tage }"/></td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td><input type="text" name="p_q" value="${ProductMngVO.p_q }"/></td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td><input type="date" name="p_sdate" value="${ProductMngVO.p_sdate }"/></td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td><input type="date" name="p_edate" value="${ProductMngVO.p_edate }"/></td>
					</tr>
					<tr>
						<th>업데이트된 날짜</th>
						<td><input type="date" name="p_moddate" value="${ProductMngVO.p_moddate }"/></td>
					</tr>
					<tr>
						<td colspan="2"><br/><input type="submit" value="수정완료" > &nbsp;
						<input type="button" value="이전으로" onclick="location.href='/shop/mng/product/EgovMngProductlist.do'"/>
					</tr>
				</table>
					<%-- <c:if test=""></c:if> --%>
				</form>				
			</div>
		</div>
	</div>

<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>