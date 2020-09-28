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


</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>


<div class="container">
		<div class="row">


			<table class="table mx-auto">
				<tr>
					<th>판매자 아이디</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>판매자 사진</th>
					<th>판매자 상태여부</th>
					<th>핸드폰 번호</th>
					<th>주소</th>
					<th>성별</th>
					<th>수정일</th>
					<th>등록일</th>
					<th>생년월일</th>
					<th>계좌번호</th>
				</tr>
				
				
				
				<c:forEach items="${list }" var="s_list" varStatus="status">
					<tr>
						<td>${s_list.s_id }</td>
						<td>${s_list.s_nickname }</td>
						<td>${s_list.s_email }</td>
						<td>${s_list.s_photo }</td>
						<td>${s_list.s_status }</td>
						<td>${s_list.s_phone }</td>
						<td>${s_list.s_addr }</td>
						<td>${s_list.s_gender }</td>
						<td>${s_list.s_moddate }</td>
						<td>${s_list.s_regdate }</td>
						<td>${s_list.s_birth }</td>
						<td>${s_list.s_account }</td>
						<td><input type="submit" value="전환"
							form="frm${status.index }" /></td>
					</tr>
				</c:forEach>
			</table>


			
			
			
			<div id="paging_div">
				<ul class="paging_align">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="fn_egov_select_productList" />
				</ul>
			</div>
		</div>
	</div>


</body>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>