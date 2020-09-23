<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%-- <%@ page import ="egovframework.com.cmm.LoginVO" %> --%>
<%@ page import="egovframework.let.shop.review.service.ReviewVO"%>
<%@ include file="../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
<h1>리뷰입니다</h1>
<c:forEach items="${list}" var="result">
	<a>판매자아이디 : ${result.s_id }</a> <p>
	<a>구매자 아이디 : ${result.sns_idx }</a> <p>
	<a>리뷰 번호 : ${result.r_idx }</a> <p>
	<a>상품 번호 : ${result.p_idx }</a> <p>
	<a>상품 후기 : ${result.r_content }</a> <p>
	<a>후기 등록일자 : ${result.r_regdate }</a> <p>
	<a>판매자 평점 : ${result.sns_score }</a> <p>	
</c:forEach> 
</body>
</html>