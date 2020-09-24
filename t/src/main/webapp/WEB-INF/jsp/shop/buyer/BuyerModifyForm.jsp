<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import="egovframework.com.cmm.LoginVO"%>
<%@ include file="../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${msg != null }">${msg }</c:if>
<c:if test="${msg = null }"> </c:if>
<form action="/shop/buyer/BuyerModifyPro.do" method="post">
<input type="hidden" name="sns_idx" value="${BuyerVO.sns_idx }" />
<table>
	<tr>
		<th>회원번호</th>
		<td>${BuyerVO.sns_idx }</td>
	</tr>
	<tr>
		<th>회원아이디</th>
		<td><input type="text" name="userid" value="${BuyerVO.userid }"/></td>
	</tr>
	<tr>
		<th>SNS 코드</th>
		<td><input type="text" name="snscode" value="${BuyerVO.snscode }"/></td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td><input type="text" name="nickname" value="${BuyerVO.nickname }"/></td>
	</tr>
	<tr>
		<th>이메일 주소</th>
		<td><input type="text" name="email" value="${BuyerVO.email }"/></td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>${BuyerVO.reg_date }</td>
	</tr>
	<tr>
		<th>상태</th>
		<td><input type="text" name="del_yn" value="${BuyerVO.del_yn }"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정" />
			<input type="button" value="목록으로" onclick="location.href='/shop/buyer/BuyerList.do'"/>
		</td>
	</tr>
</table>
</form>

</body>
</html>