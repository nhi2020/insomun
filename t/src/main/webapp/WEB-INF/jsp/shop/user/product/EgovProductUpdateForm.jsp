<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<h2>수정 페이지</h2>

	<c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
	
 <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
			<form action="/shop/product/EgovProductUpdatePro.do" method="post">
	    <input type="hidden" name="p_idx" value="${ProductVO.p_idx }" />
					<img src="./images/main/photo/${ProductVO.p_image}" width="270" height="385"/>
						<p>
					<table class="table">
					<tr>
						<th>상품명</th>
						<td><input type="text" name="p_name" value="${ProductVO.p_name }"/>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="p_price" value="${ProductVO.p_price }"/></td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td>
						<textarea rows="5" cols="50" name="p_content" id="p_content">${ProductVO.p_content } </textarea></td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td><input type="text" name="p_tage" value="${ProductVO.p_tage }"/></td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td><input type="text" name="p_q" value="${ProductVO.p_q }"/></td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td><input type="date" name="p_sdate" value="${ProductVO.p_sdate }"/></td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td><input type="date" name="p_edate" value="${ProductVO.p_edate }"/></td>
					</tr>
					<tr>
						<th>업데이트된 날짜</th>
						<td><input type="date" name="p_moddate" value="${ProductVO.p_moddate }"/></td>
					</tr>
					<tr>
						<td colspan="2"><br/><input type="submit" value="수정완료" > &nbsp;
					<input type="button" value="삭제"></td>
					</tr>
				</table>
					<%-- <c:if test=""></c:if> --%>
				</p>
				</form>				
			</div>
		</div>
	</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>