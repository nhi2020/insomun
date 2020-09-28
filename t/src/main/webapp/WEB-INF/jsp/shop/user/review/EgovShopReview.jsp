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
	
</script>
<body>
<form action="/shop/user/review/insertUserReview.do" name="frm2" method="post">
	<div class="container text-center">
			<div class="row justify-content-center">
			<input type="hidden" id="s_id" name="s_id" value="shong1">
			<input type="hidden" id="sns_idx" name="sns_idx" value="1">
			<input type="hidden" id="p_idx" name="p_idx" value="1">
			<input type="hidden" id="r_div" name="r_div" value="1">
			<textarea rows="5" cols="80" name="r_content" id="r_content"></textarea>
			
			<input type="submit" value="확인">
			</div>
	</div>
</form>
<form name="frm" method="post">
 	<input type="hidden" name="r_idx" value=""/>
 	<input type="hidden" name="r_content" value=""/>
<c:forEach items="${list}" var="result">
<div class="container text-center">
			<div class="row justify-content-center">
		<table border="1">
			<thead>
				<tr>
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
					<td>${result.s_nickname }</td>
					<td>${result.nickname }</td>
					<td>${result.p_name }</td>
					<td>
						<div id="r_view${result.r_idx}" style="display: none;">
							<textarea id="r_contentVal${result.r_idx}" name="r_contentVal${result.r_idx}" rows="5" cols="40">
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
</body>
</html>