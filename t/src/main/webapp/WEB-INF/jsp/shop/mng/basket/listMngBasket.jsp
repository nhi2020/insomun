<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
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

	<table class="table">
			<tr>
				<th>장바구니 번호</th>
				<th>고객번호</th>
				<th>고객 아이디</th>
				<th>고객 SNS</th>
				<th>상품번호</th>
				<th>판매자 아이디</th>
				<th>상품 수량</th>
				<th>수정</th>
				<th>장바구니 등록일</th>
				<th>삭제</th>
				
			</tr>
		<c:forEach items="${list }" var="basketList" varStatus="status">
			<tr>
				<td>${basketList.ba_idx }</td>
				<td>${basketList.sns_idx }</td>
				<td>${basketList.userid }</td>
				<td>${basketList.snscode }</td>
				<td>${basketList.p_idx }</td>
				<td>${basketList.s_id }</td>
				<td><input class="form-control form-control-sm" type="text" form="frm${status.index }" name="ba_q" value="${basketList.ba_q }"/></td>
				<td><input class="btn btn-secondary" type="submit" value="수정" form="frm${status.index }" /></td>
				<fmt:formatDate var="dateTempFmt" value="${basketList.ba_reg_date }" pattern="yyyy.MM.dd"/>
				<td><c:out value="${dateTempFmt}"></c:out></td>
				<td><input class="btn btn-danger" type="button" value="삭제" form="frm${status.index }" /></td>
			</tr>
			<form id="frm${status.index }" action="updateMngBasket.do">
			<input type="hidden" name="ba_idx" value="${basketList.ba_idx }" />
			<input type="hidden" name="sns_idx" value="${basketList.ba_idx }" />
			<input type="hidden" name="userid" value="${basketList.ba_idx }" />
			<input type="hidden" name="snscode" value="${basketList.ba_idx }" />
			<input type="hidden" name="p_idx" value="${basketList.ba_idx }" />
			<input type="hidden" name="s_id" value="${basketList.ba_idx }" />
			<input type="hidden" name="reg_date" value="${basketList.ba_reg_date }" />
			
			</form>
		</c:forEach>
	</table>
	<form action="/shop/mng/basket/listMngBasket.do">
	<input type="hidden" name="searchCnd" value="0"/>
	<input type="text" name="searchWrd" /> <input class="btn btn-primary" type="submit" value="아이디 검색" />
	
	</form>
		<div id="paging_div">
		<ul class="paging_align">	
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_productList" />
		</ul>
	</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>