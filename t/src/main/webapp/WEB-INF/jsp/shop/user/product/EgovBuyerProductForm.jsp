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
<script type="text/javascript">
	function likeUserInsert(){
		document.frm.action="/shop/user/product/LikeUserInsert.do";
		document.frm.submit();
	}
</script>

</head>

<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>

  
  <h2>상품 상세 페이지</h2>
 <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
			<form name="frm" method="post">
				<input type="hidden" name="s_id" value="${ProductUserVO.s_id }"/>
		    	<input type="hidden" name="p_idx" value="${ProductUserVO.p_idx }" />
					<img src="./images/main/photo/${ProductUserVO.p_image}" width="270" height="385" class="float-left"/>
						<p>
					<table class="table">
					<tr>
						<th>상품명</th>
						<td>${ProductUserVO.p_name}
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${ProductUserVO.p_price }</td>
						<!-- <th class="dropdown">
  					<button class="dropbtn">Dropdown</button>
  					<div class="dropdown-content">
  					<div class="dropdown">Dropdown</div>
    				<a>1</a>
    				<a>2</a>
    				<a>3</a>
  </div>
</div> -->
					</tr>
					<tr>
						<th>제품 내용</th>
						<td>${ProductUserVO.p_content }</td>
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
				</table>
				
				<p/>
				<p/>
				<input type="submit" value="장바구니" onclick=""/>
				<input type="submit" value="찜하기" onclick="likeUserInsert();"/>
				<input type="submit" value="바로구매" onclick=""/>
				
				<p/>
				<input type="button" value="목록" onclick="location.href='/shop/user/product/EgovUserProductlist.do'"/>
					<%-- <c:if test=""></c:if> --%>
				</p>
				</form>				
			</div>
		</div>
	</div>

<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>