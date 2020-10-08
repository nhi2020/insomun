<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%-- <%@ page import ="egovframework.com.cmm.LoginVO" %> --%>
<%@ page import="egovframework.let.shop.mng.review.service.ReviewMngVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">

<title>Insert title here</title>
</head>
<body>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<%@ include file="../../inc/EgovShopHeader.jsp"%>
<p class="h-25"/>
<div class="container text-center">
	<div class="row justify-content-center">
		<table border="1">
				<tr>
					<td><a href="/shop/mng/review/MngSelect.do"> 판매자 리뷰</a></td>
					<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
					<td><a href="/shop/mng/review/MngUserSelect.do">관리자 리뷰</a></td>
				</tr>
		</table>
	</div>
</div>
</body>
</html>