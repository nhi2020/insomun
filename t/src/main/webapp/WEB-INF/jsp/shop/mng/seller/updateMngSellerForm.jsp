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



	<c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
	<div class="container">
		<div class="row">
			<form class="mx-auto" action="/shop/mng/seller/updateMngSellerPro.do" method="post">
				<input type="hidden" name="s_id" value="${SellerVO.s_id }" />

					<img src="<c:url value='/'/>images/shop/seller/${SellerVO.s_photo }" width="400" height="400"/>
					
					<p>
					
					<input type="button" value="사진변경"/>
					
					<p>
					
				<table class="table">				
				
					<tr>
						<th>회원아이디</th>
						<td>${SellerVO.s_id }</td>
					</tr>
			
					<tr> 
						<th>닉네임</th>
						<td><input type="text" name="s_nickname"
							value="${SellerVO.s_nickname }" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="s_email" value="${SellerVO.s_email }" /></td>
					</tr>
					<tr>
						<th>상태</th>
						<c:choose>
							<c:when test="${SellerVO.s_status eq 'Y'}">
								<td>활동중인 계정</td>
							</c:when>
							<c:when test="${SellerVO.s_status eq 'N'}">
								<td>탈퇴된 계정</td>
							</c:when>
						</c:choose>	
					</tr>
					<tr>
						<th></th>
						<td><input type="radio" name="s_status" value="Y"/>활동중인 계정
							<input type="radio" name="s_status" value="N"/>탈퇴된 계정
						</td>
					</tr>
					<tr>
						<th>핸드폰 번호</th>
						<td><input type="text" name="s_phone"
							value="${SellerVO.s_phone }" /></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="s_addr"
							value="${SellerVO.s_addr }" /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${SellerVO.s_gender }</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${SellerVO.s_regdate }</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="수정" /> 
						<input type="button" value="목록으로" onclick="location.href='/shop/mng/seller/listMngSeller.do'" />
						<input type="button" value="강제 로그인" onclick="location.href='/shop/user/seller/EgovsellerLoginPro.do?id=${SellerVO.s_id}&passwd=${SellerVO.s_pass }'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
