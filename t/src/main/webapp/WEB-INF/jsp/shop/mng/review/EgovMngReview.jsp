<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import="egovframework.let.shop.mng.review.service.ReviewMngVO"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function delReview() {
		/* alert(document.frm.chk.length); */
		document.frm.action="/shop/mng/review/delMngReview.do";
		document.frm.submit();
	}
	function reReview() {
		document.frm.action="/shop/mng/review/reMngReview.do";
		document.frm.submit();
	}
</script>
<body>
<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
<div class="container text-center">
	<div class="row justify-content-center">
		<h2>구매자 리뷰 관리자 페이지입니다.</h2>
		</div></div>
<div class="container text-center">
	<div class="row justify-content-center">
		<form method="post" name="frm">
			<table border="1">
					<thead>
						<tr>
							<th>리뷰 번호</th>
							<th>구매자 닉네임</th>
							<th>구매자 리뷰</th>
							<th>구매자리뷰 등록일자</th>
							<th>리뷰 삭제여부</th>
							<th>리뷰 삭제하기</th>
							<th>리뷰 복구하기</th>
						</tr>
					</thead> 
				<c:forEach var="result" items="${list }" varStatus="i">
					<tbody>
						<tr>
							<td>${result.r_idx }</td>
							<td>${result.nickname }</td>
							<td>${result.r_content }</td>
							<td>${result.r_regdate }</td>
							<td>${result.r_delyn }</td>
							<td><input type="checkbox" name="chk" id="chk" value="${result.r_idx }"></td>
							<td><input type="checkbox" name="rechk" id="rechk" value="${result.r_idx }"></td>
						</tr>
					</tbody>
				</c:forEach>
						<tr>
							<td colspan="5"></td>
							<td><input type="button" value="삭제" onclick="delReview();"></td>
							<td><input type="button" value="복구" onclick="reReview();"></td>
						</tr>
			</table>
		</form>
	</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>