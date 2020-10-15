<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import="egovframework.let.shop.mng.product.service.impl.ProductMngVO" %>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>판매자 수정 페이지</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<h2>수정 페이지</h2>

 <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
			<form action="/shop/user/product/EgovUserProductUpdatePro.do" method="post" >
	    			<input type="hidden" name="p_idx" value="${ProductUserVO.p_idx }" />
					<img src="<c:url value='/'/>file/${ProductUserVO.p_image}" width="270" height="385"/>
					<p>
					<table class="table">
					<tr>
						<th>사진변경</th>
						<td><input type="file" name="file" value="${ProductUserVO.p_image}" />
						</td>
					</tr>
					<tr>
						<th>상품명</th>
						<td><input type="text" name="p_name" value="${ProductUserVO.p_name }"/>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="p_price" value="${ProductUserVO.p_price }"/></td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td>
						<textarea rows="5" cols="50" name="p_content" id="p_content">${ProductUserVO.p_content } </textarea></td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td><input type="text" name="p_tage" value="${ProductUserVO.p_tage }"/></td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td><input type="text" name="p_q" value="${ProductUserVO.p_q }"/></td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td><input type="date" name="p_sdate" value="${ProductUserVO.p_sdate }"/></td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td><input type="date" name="p_edate" value="${ProductUserVO.p_edate }"/></td>
					</tr>
					<tr>
						<th>업데이트된 날짜</th>
						<td><input type="date" name="p_moddate" value="${ProductUserVO.p_moddate }"/></td>
					</tr>
					<tr>
						<td colspan="2"><br/>
					<input type="submit" value="수정완료" class="btn btn-primary"> &nbsp;
					<input type="button" value="이전으로" class="btn btn-info" onclick="location.href='/shop/user/product/EgovUserProductlist.do'"/>
					</tr>
				</table>
				<p/>
				</form>				
			</div>
		</div>
	</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>