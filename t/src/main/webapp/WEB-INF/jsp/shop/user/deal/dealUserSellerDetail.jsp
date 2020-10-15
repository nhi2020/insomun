<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopTop.jsp" %>
<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopHeader.jsp" %>
<div class="container">
<h1>거래</h1><p1>
<h4>판매자</h4><p1>

	sns_idx : ${dealUserVO.sns_idx}<br>		
	d_idx : ${dealUserVO.d_idx}<br>			
	p_idx : ${dealUserVO.p_idx }<br>		
	s_id : ${dealUserVO.s_id }<br>		
	
거래상태 : <strong>
			<c:choose>
				<c:when test="${dealUserVO.d_ing eq '1'}"> 신청 </c:when>
				<c:when test="${dealUserVO.d_ing eq '2'}"> 수락 </c:when>
				<c:when test="${dealUserVO.d_ing eq '3'}"> 배송시작 </c:when>
				<c:when test="${dealUserVO.d_ing eq '4'}"> 구매 확정 </c:when>
				<c:when test="${dealUserVO.d_ing eq '5'}"> 구매자 거래 취소 </c:when>
				<c:when test="${dealUserVO.d_ing eq '6'}"> 판매자 거래 취소 </c:when>
			</c:choose>
		</strong><br>
구매자<strong>${dealUserVO.nickname }[신용도 : <strong>${dealUserVO.seller_score}</strong>]</strong>가<br>
<strong>${dealUserVO.p_name } ${dealUserVO.d_q }</strong> 개 구매 하였습니다.<br>
거래 진행 시 아래 거래 진행을 클릭하여 주시고,<br>
사정에 의해서 거래 파기시 아래 거래 파기를 클릭해 주시기 바랍니다.<br>
구매자와 입금 확인 및 상품 전달 완료 시 거래 완료 클릭해 주시기 바랍니다.<br>


	    	<br><button type="button" class="btn btn-warning"  onclick="location.href='/shop/user/deal/dealUserSellerAccept.do?d_idx=${dealUserVO.d_idx}'"><i class="fa fa-bars">수락</i></button>
	    	<button type="button" class="btn btn-warning"  onclick="location.href='/shop/user/deal/dealUserSellerCancel.do?d_idx=${dealUserVO.d_idx}'"><i class="fa fa-bars">거래 파기</i></button>
	    	<button type="button" class="btn btn-warning"  onclick="location.href='/shop/user/deal/dealUserSellerDeliver.do?d_idx=${dealUserVO.d_idx}'"><i class="fa fa-bars">배송 시작</i></button>
	    	<br><button type="button" class="btn btn-warning"  onclick="location.href='/shop/user/deal/dealUserSellerList.do'"><i class="fa fa-bars">목록</i></button>
</div>
<%@ include file="/WEB-INF/jsp/shop/inc/EgovShopBottom.jsp" %>
</body>
</html>