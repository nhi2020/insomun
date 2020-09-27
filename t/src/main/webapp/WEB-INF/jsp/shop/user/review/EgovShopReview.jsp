<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%-- <%@ page import ="egovframework.com.cmm.LoginVO" %> --%>
<%@ page import="egovframework.let.shop.mng.review.service.ReviewMngVO"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>Insert title here</title>
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
	/* function productRivew(idx){
		var r_mainContent = "r_mainContent"+idx;
		document.frm.r_mainContent.value=document.getElementById(r_mainContent).value;
		document.frm.r_idx.value=idx;
		document.frm.action="mainReviewUpdate.do";
		document.frm.submit();
	} */
</script>
<body>

<form action="/shop/user/review/updateUserReview.do" name="frm" method="post">
 	<input type="hidden" name="r_idx" value=""/>
 	<input type="hidden" name="r_content" value=""/>
 	<input type="hidden" name="r_mainContent" value=""/>
 <div class="container text-center">
			<div class="row justify-content-center">
				<input type="text" id="mainReview" name="rivew0" value="리뷰를 작성하세요."><p>
				<input type="submit" value="확인">
			</div>
</div>
<c:forEach items="${list}" var="result">
<div class="container text-center">
			<div class="row justify-content-center">
	<table border="1">
		<thead>
			<tr>
				<th>리뷰 번호</th>
				<th>판매자 이름</th>
				<th>구매자 이름</th>
				<th>상품 명</th>
				<th>리뷰 내용</th>
				<th>리뷰 등록일자</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${result.r_idx }</td>
				<td>${result.s_nickname }</td>
				<td>${result.nickname }</td>
				<td>${result.p_name }</td>
				<td>
					<div id="r_view${result.r_idx}" style="display: none;">
						<textarea id="r_contentVal${result.r_idx}" name="r_contentVal${result.r_idx}" rows="11" cols="11">
							${result.r_content }
						</textarea>
						<a href="javascript:updateUserReview('${result.r_idx}');">저장</a>
					</div>
					<div id="r_view2${result.r_idx}" style="display: block;">
						${result.r_content }
					</div>
				</td>
				<td>${result.r_regdate }</td>
				<td>
					<c:if test="${'1' eq result.sns_idx}">
						<a href="javascript:displayView('${result.r_idx}');">수정</a>
					</c:if>
				</td>
				<td>
					<c:if test="${'1' eq result.sns_idx}">
						<a href="javascript:delUserReview('${result.r_idx}');">삭제</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</div>
</c:forEach> 
</form>
<%-- <div id="r_view0${result.r_idx}">
					<textarea id="r_mainContent${result.r_idx}" name="r_mainContent${result.r_idx}" rows="11" cols="11"></textarea>
					<a href="javascript:productRivew('${result.r.idx }');">저장</a>
					<!-- 메인 후기글, 구매자 평점,  -->
				</div> --%>
</body>
</html>