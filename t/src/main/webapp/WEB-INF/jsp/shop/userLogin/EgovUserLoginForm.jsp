<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
 
<body>
<%@ include file="../inc/EgovShopHeader.jsp" %> 
	<a href="/shop/user/EgovKakaoLogin.do">aa</a><br/>
  	<a href="${kakaoUrl}">카카오로그인</a><br/>
  	<a href="${naverUrl}">네이버로그인</a> 
</body>
</html>