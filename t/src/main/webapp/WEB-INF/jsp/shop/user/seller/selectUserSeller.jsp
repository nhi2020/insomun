<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<style type="text/css">

 #nav {
            display: flex;
            height: 100px;
            background-color: grey;
            color: white;
        }
 .menu-item {
            font-size: 24px;
            padding: 5px 23px;
            display: flex;
            align-items: center;
        }
 #div_con1 {
 			width: 50%;
 			height: 400px;
 			float: left;
 }
  #div_con2 {
 			width: 50%;
 			height: 400px;
 			float: right;
 }
   #div_bottom {
 			width: 100%;
 			height: 100px;
 			clear: both;
 }
</style>
</head>
<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	
	<!-- result 값을 이용한 modal -->
	<c:if test="${result == 1}">
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateModal").modal('show')
			
			})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	

	<h5 style="color: grey; text-align: center; margin-top: 50px">입소문넷 회원 ${SellerVO.s_nickname}님 안녕하세요!</h5>
	
	<div class="w-auto p-3">

	
	<div id="nav">
        <div class="menu-item" id="item8"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/seller/updateUserSellerForm.do?s_id=${SellerVO.s_id}'" value="정보수정"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/product/EgovUserProductlist.do?s_id=${SellerVO.s_id}'" value="내 상품보기"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/product/EgovUserProductInsertForm.do?s_id=${SellerVO.s_id}'" value="상품추가"></div>
		<div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/deal/dealUserSellerList.do'" value="내 거래내역보기"></div>
 	 	<div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/mng/review/MngSelect.do'" value="리뷰관리"></div>

    </div>
    
    <p>
    
	 <div class="p-3 mb-2 bg-light text-dark" id="div_con1">
            <h3>내 정보보기...</h3>	
        <p><p><p><p><p>
        <img src="<c:url value='/'/>file/${s_list.s_photo}" width="300" height="300"/>
			${SellerVO.s_id}
			${SellerVO.s_nickname}
			${SellerVO.s_birth}
			${SellerVO.s_addr}
	</div>
	
	<p>

	 <div class="p-3 mb-2 bg-light text-dark" id="div_con2">
            <h3>내 상품보기...</h3>	
        <p><p><p><p><p>
					<c:forEach var="product_list" items="${list}" varStatus="status" begin="1" end="5">
					<div class="mt-3">
							<li><img src="<c:url value='/'/>file/${product_list.p_image}" width="30" height="30" class="rounded"/> 
							 ${product_list.p_name }
							판매자: ${product_list.s_id }
							가격 : 
							<fmt:formatNumber value="${product_list.p_price }" pattern="##,###"></fmt:formatNumber>
					</div>
					</c:forEach>
		
		<a href="/shop/user/product/EgovUserProductlist.do?s_id=sid">자세히...</a></p>
	</div>
	
	<p>

	<div class="p-3 mb-2 bg-light text-dark" id="div_con1">
			<h3>내 거래내역 보기...</h3>
		<p><p><p><p><p>
     			  <c:forEach  items="${dealUserlist }" var="list" varStatus="status" begin="1" end="5">
					<div class="mt-3">
								<li>
								${list.p_name}
								${list.d_q }개
								${list.p_price * list.d_q  }원
								${list.d_regdate }
								${list.nickname }
								<c:choose>
									<c:when test="${list.d_ing eq '1'}"> 신청 </c:when>
									<c:when test="${list.d_ing eq '2'}"> 수락 </c:when>
									<c:when test="${list.d_ing eq '3'}"> 배송시작 </c:when>
									<c:when test="${list.d_ing eq '4'}"> 구매 확정 </c:when>
									<c:when test="${list.d_ing eq '5'}"> 구매자 거래 취소 </c:when>
									<c:when test="${list.d_ing eq '6'}"> 판매자 거래 취소 </c:when>
								</c:choose>
					</div>
					</c:forEach>
					
		<a href="/shop/user/deal/dealUserSellerList.do">자세히...</a></p>
	</div>
	
	<p>

	 <div class="p-3 mb-2 bg-light text-dark" id="div_con2">
            <h3>내 상품에 달린 리뷰 보기...</h3>	
        <p><p><p><p><p>
					<c:forEach items="${list1}" var="result"  begin="1" end="3">
						<c:choose>
				          	<c:when test="${result.r_div eq '1'}">
				          	<span class="font-weight-normal" style="color: red">판매자</span><br>
				          		${result.nickname}&nbsp;<span class="font-weight-normal">${result.r_regdate}&nbsp;판매자 점수 :${result.sns_score}</span>
				          	</c:when>
					       	<c:otherwise>
					       	<span class="font-weight-normal" style="color: red">구매자</span><br>
					       		${result.s_nickname}&nbsp;<span class="font-weight-normal">${result.r_regdate}&nbsp;구매자 점수 :${result.seller_score}</span>
					       	</c:otherwise>
				        </c:choose>
			        </p>
					<div id="r_view${result.r_idx}" style="display: none;">
						<textarea id="r_contentVal${result.r_idx}" name="r_contentVal${result.r_idx}" rows="5" cols="70">${result.r_content }</textarea>
						<a href="javascript:updateUserReview('${result.r_idx}');">저장</a>
					</div>
					<div id="r_view2${result.r_idx}" style="display: block;">
						<pre>${result.r_content}</pre>
					</div>
					<div class="float-right">
						<c:if test="${'1' eq result.sns_idx}">
							<a href="javascript:displayView('${result.r_idx}');"><span style="color: gray;">수정</span></a>
						</c:if>
						<c:if test="${'1' eq result.sns_idx}">
							<a href="javascript:delUserReview('${result.r_idx}');"><span style="color: gray;">삭제</span></a>
						</c:if>
					</div>
					</c:forEach>
		
		<a href="/shop/mng/review/MngSelect.do">자세히...</a></p>
	</div>

	</div> 
	<div id="div_bottom">
<%@ include file="../../inc/EgovShopBottom.jsp" %>
	</div>
</body>
</html>