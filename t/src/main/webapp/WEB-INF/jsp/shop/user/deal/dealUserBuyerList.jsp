<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
  
<%
	String context = request.getContextPath();
%>
  
  
<h1>현재 진행중인 거래...구매자</h1>

거래상태 설명<br>
신청 : 구매 클릭 후 판매자 거래 수락 전 단계<br>
수락 : 판매자 거랙 수락 후 구매자 입금 및 판매자 배송 단계<br>
구매 확정 : 판매자 입금 확인 및 구매자 물품 수령 및 최종 확인<br>
거래 취소 : 어떠한 사유로 거래 취소 * 구매 확정 시 취소 안됨<br>
<div class="container">
	<div class="row">

	<table class="table mx-auto">
			<tr>
				<th>거래번호</th>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>상품수량</th>
				<th>가격</th>
				<th>거래 등록 일시</th>
				<th>판매자</th>
				<th>거래상태</th>
				<th>거래 완료 일시</th>
			</tr>

		<c:forEach items="${deallist }" var="list" varStatus="status">
			<tr onclick="rowclick(${status.index})">
				<td>${list.rn }</td>
				<td>${list.p_idx }</td>
				<td>${list.p_name }</td>
				<td>${list.d_q }</td>
				<td>${list.p_price * list.d_q  }원</td>
				<td>${list.d_regdate }</td>
				<td>${list.s_nickname }</td>
				<td>
					<c:choose>
						<c:when test="${list.d_ing eq '1'}"> 신청 </c:when>
						<c:when test="${list.d_ing eq '2'}"> 수락 </c:when>
						<c:when test="${list.d_ing eq '3'}"> 구매확정 </c:when>
						<c:when test="${list.d_ing eq '4'}"> 거래 취소 </c:when>
					</c:choose>
				</td>
				<td>${list.d_edate }</td>
			</tr>
			<form id="frm${status.index }" action="/shop/mng/deal/dealBuyerMngDetail.do">
			<input type="hidden" name="d_idx" value="${list.d_idx }">
			</form>
		</c:forEach>
	</table>
	</div>
		</div>

	<script type="text/javascript">
	function rowclick(index){
		alert("rowclick " + index)
		document.forms["frm"+index].submit();
	}

</script>


<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>