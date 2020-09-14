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
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnlogout").click(function(){	
		location.href = "shop/main/EgovMain";
	});
});
</script>
</head>

<body>
<%@ include file="../inc/EgovShopHeader.jsp" %>
  ${sessionScope.userid }<br/>
  ${sessionScope.nickname }<br/>
  ${sessionScope.email }
  
  
 <%--  <c:if test="${!sessionscope.userid ne null }"> --%>
	  <form name="logout" action="/shop/user/EgovUserLogout.do">
	  	<button type="button" id="btnlogout">logout</button>
	  </form>
  <%-- </c:if> --%>
</body>
</html>