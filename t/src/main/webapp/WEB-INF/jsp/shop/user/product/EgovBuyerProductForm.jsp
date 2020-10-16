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
<title>상세페이지</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>
<script type="text/javascript">
	//삭제
	function delUserReview(idx){
		document.frm.r_idx.value=idx;
		document.frm.action="/shop/user/review/delUserReview.do";
		document.frm.submit();
	}
	//본인이쓴 id 만 수정 삭제할수있게 보여준다.
	function displayView(idx){
		var str="r_view"+idx;
		var str2="r_view2"+idx;
		document.getElementById(str).style.display="block";
		document.getElementById(str2).style.display="none";
	}
	//수정
	function updateUserReview(idx){
		var r_contentVal="r_contentVal"+idx;
		document.frm.r_content.value=document.getElementById(r_contentVal).value;
		document.frm.r_idx.value=idx;
		document.frm.action="updateUserReview.do";
		document.frm.submit();
	}
	//상품에 첫 후기작성
	
	//--------------------------
</script>
<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>

  <div class="container text-center">
		<div class="row justify-content-center">
  <h2>상품 상세 페이지</h2>
  </div></div>
 <div class="container text-center">
		<div class="row justify-content-center">
	    <div class="row">
			<form name="frm" action=""  enctype="multipart/form-data">
	    <input type="hidden" name="p_idx" value="${ProductUserVO.p_idx }" />
	    <input type="hidden" name="s_id" value="${ProductUserVO.s_id }" />
					<img class="img-fluid" src="<c:url value='/'/>file/${ProductUserVO.p_image}" width="200" height="200"/>
						<p>
					<table class="table" style="text-align: left">
					<tr>
						<th>상품명</th>
						<td>${ProductUserVO.p_name}
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${ProductUserVO.p_price }</td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td>${ProductUserVO.p_tage }</td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td>${ProductUserVO.p_q }</td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td>${ProductUserVO.p_sdate }</td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td>${ProductUserVO.p_edate }</td>
					</tr>
					<tr>
						<th>업데이트된 날짜</th>
						<td>${ProductUserVO.p_moddate }</td>
					</tr>
					<tr>
						<th>제품 내용</th>
						<td width="400px;">${ProductUserVO.p_content }</td>
					</tr>
				</table>
				
				<p/>
				<p/>
				<input type="button" value="장바구니" class="btn btn-primary" onclick="goBasket(); return false;"/>
				<input type="submit" value="찜하기" class="btn btn-primary" onclick="goLike(); return false;"/>
				<input type="button" value="바로구매" class="btn btn-primary" onclick="location.href='/shop/user/deal/dealUserBuyerRequest.do?p_idx=${ProductUserVO.p_idx}&s_id=${ProductUserVO.s_id }'"/>
				<p/>
				<input type="button" value="목록" class="btn btn-info" onclick="location.href='/shop/user/product/EgovUserProductlist.do'"/>
				</p>
				</form>				
			</div>
		</div>
	</div>
<script type="text/javascript">
	function goBasket() {
		document.frm.action = "/shop/user/basket/insertBasketUserPro.do";
		document.frm.submit();
	}
	
	function goLike() {
		document.frm.action = "/shop/user/product/LikeUserInsert.do";
		document.frm.submit();
	}
</script>
	<c:if test="${sessionScope.status == 2 }">
		<p class="h-25"/>
			<form action="/shop/user/review/insertUserReview.do" name="frm2" method="post" enctype="multipart/form-data">
			<div class="container text-center">
				<div class="row justify-content-center">
					<input type="hidden" id="s_id" name="s_id" value="${ProductUserVO.s_id }">	<!-- 상품 상세페이지가 나오면  EL표기법으로 값가져오기. -->
					<input type="hidden" id="p_idx" name="p_idx" value="${ProductUserVO.p_idx }">
					<input type="hidden" id="r_div" name="r_div" value="1">
					<textarea rows="3" cols="80" name="r_content" id="r_content"></textarea>
					<input type="file" name="file" id="file">
					<input type="submit" value="저장" class="btn btn-primary">
				</div>
				<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" name="sns_score" id="customRadio1" value="1"><p>1점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="2"><p>2점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="3"><p>3점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="4"><p>4점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="5"><p>5점</p>
				</div>
				<h3>리뷰 평균 평점 : ${AVG }</h3>														<!-- 시간남으면 상품 사진까지 올릴수있도록 -->
			</div>																<!-- 추가해보기 -->
		</form>
		<p class="h-25"/>
		<form name="frm3" method="post">
		 	<input type="hidden" name="r_idx" value=""/>
		 	<input type="hidden" name="r_content" value=""/>
		<c:forEach items="${list}" var="result">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8 border border-1 p-3">
					<p class="font-weight-bold">
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
				</div>
			</div>
		</div>
		</c:forEach>
				<%-- <ul class="paging_align">
								<ui:pagination paginationInfo="${paginationInfo}" type="text"
									jsFunction="linkPage" />
							</ul> --%>
		</form>
		</c:if>
		<c:if test="${sessionScope.status == 1 }">
			<p class="h-25"/>
			<form action="/shop/user/review/insertUserReview.do" name="frm2" method="post" enctype="multipart/form-data">
			<div class="container text-center">
				<div class="row justify-content-center">
					<input type="hidden" id="s_id" name="s_id" value="${ProductUserVO.s_id }">	<!-- 상품 상세페이지가 나오면  EL표기법으로 값가져오기. -->
					<input type="hidden" id="sns_idx" name="sns_idx" value=" ">
					<input type="hidden" id="p_idx" name="p_idx" value="${ProductUserVO.p_idx }">
					<input type="hidden" id="r_div" name="r_div" value="1">
					<textarea rows="3" cols="80" name="r_content" id="r_content"></textarea>
					<input type="file" name="file" id="file">
					<input type="submit" value="저장" class="btn btn-primary">
				</div>
				<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" name="sns_score" id="customRadio1" value="1"><p>1점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="2"><p>2점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="3"><p>3점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="4"><p>4점</p>
							<input type="radio" name="sns_score" id="customRadio1" value="5"><p>5점</p>
				</div>
				<h3>리뷰 평균 평점 : ${AVG }</h3>														<!-- 시간남으면 상품 사진까지 올릴수있도록 -->
			</div>																<!-- 추가해보기 -->
		</form>
		<p class="h-25"/>
		<form name="frm3" method="post">
		 	<input type="hidden" name="r_idx" value=""/>
		 	<input type="hidden" name="r_content" value=""/>
		<c:forEach items="${list}" var="result">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8 border border-1 p-3">
					<p class="font-weight-bold">
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
				</div>
			</div>
		</div>
		</c:forEach>
				<%-- <ul class="paging_align">
								<ui:pagination paginationInfo="${paginationInfo}" type="text"
									jsFunction="linkPage" />
							</ul> --%>
		</form>
		</c:if>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>