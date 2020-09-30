<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
</head>
<body>
<h2>관리자 등록 페이지</h2>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<h2>수정페이지</h2>
  <c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
  <form action="/shop/mng/admin/adminControl/insertMngControlPro.do" name="frm2" method="post">
    <div class= "row justify-content-center">
      <input type="text" value="${AdminVO.a_id }">
      <input type="text" value="${AdminVO.a_pass }">
      <input type="text" value="${AdminVO.a_email }">
      <input type="text" value="${AdminVO.a_name }">
      <input type="submit" value="확인">
    </div>
  </form>
</body>
</html>