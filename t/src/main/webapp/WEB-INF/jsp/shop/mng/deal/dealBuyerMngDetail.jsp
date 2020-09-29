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
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<div class="container">
<h1>거래</h1><p1>
<h4>구매자</h4><p1>
<input type="hidden" name="d_idx" value="${dealMngVO.d_idx }">
거래상태 : <strong>${dealMngVO.d_ing}</strong><br>
<strong>${dealMngVO.s_nickname}</strong> [신용도 : <strong>${dealMngVO.seller_score}</strong>] 의 <strong>${dealMngVO.p_name }</strong>입니다.<br>
판매자 연락처는 <strong>${dealMngVO.s_phone }</strong>이며,<br>
계좌는 <strong>${dealMngVO.s_account}</strong>입니다.<br><br>

입금 후 거래 진행 클릭해 주세요.<br>
기타 문의 시 판매자와 연락 바랍니다.<br><br>

주소 및 배송 요청사항<br>
<textarea style="width:100%" form="${dealMngVO.d_request}" rows=5 placeholder="입금 후 입금자 명, 주소, 배송 요청사항 등을 작성해 주세요."></textarea>

	    	<br><button type="button" class="btn btn-warning"  onclick="location.href='/shop/mng/deal/dealBuyerMngIng.do?d_idx=${dealMngVO.d_idx}'"><i class="fa fa-bars">거래 진행</i></button>
	    	<button type="button" class="btn btn-warning"  onclick="location.href='/shop/mng/deal/dealBuyerMngCancel.do?d_idx=${dealMngVO.d_idx}'"><i class="fa fa-bars">거래 파기</i></button>
	    	<button type="button" class="btn btn-warning"  onclick="location.href='/shop/mng/deal/dealBuyerMngComplete.do?d_idx=${dealMngVO.d_idx}'"><i class="fa fa-bars">거래 완료</i></button>

</div>
</body>
</html>