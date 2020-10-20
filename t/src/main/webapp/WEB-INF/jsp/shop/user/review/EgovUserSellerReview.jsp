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
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../inc/EgovShopHeader.jsp" %>
<div class="container text-center">
	<div class="row justify-content-center">
		<h1>판매자가 작성한 리뷰 페이지</h1>
		<c:forEach var="result" items="${list }">
			<table border="1">
				<thead>
					<tr>
						<th>판매자 아이디</th>					
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${result.s_id }</td>
					</tr>
				</tbody>
			</table>
		</c:forEach>
	</div>
</div>
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>