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
<body>
	<div class="container text-center">
		<div class="row justify-content-center">
			<h2>구매자 리뷰 관리자 페이지입니다.</h2>
			<table border="1">
				<thead>
					<tr>
						<th>리뷰 번호</th>
						<th>닉네임</th>
						<th>리뷰 내용</th>
						<th>리뷰 등록일자</th>
						<th>리뷰 삭제여부</th>
						<th>삭제</th>
					</tr>
				</thead>
			<c:forEach items="${list }" var="result">
				<tbody>
					<tr>
						<td>${result.r_idx }</td>
						<td>${result.nickname }</td>
						<td>${result.r_content }</td>
						<td>${result.r_regdate }</td>
						<td>${result.r_delyn }</td>
						<td><input type="checkbox"></td>
					</tr>
				</tbody>
			</c:forEach>
			</table>
		</div>
			<input type="button" value="삭제">
	</div>
</body>
</html>