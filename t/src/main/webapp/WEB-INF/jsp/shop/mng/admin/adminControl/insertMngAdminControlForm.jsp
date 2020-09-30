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
  <form action="/shop/mng/admin/adminControl/insertMngAdminControlPro.do" name="frm2" method="post">
    <div class= "row justify-content-center">
     <table>
     <tr>
       <th>아이디</th>
       <td>
       <input type="text" name = "a_id" value="${AdminVO.a_id }">
       </td>
     </tr>
     <tr>
        <th>비밀번호</th>
        <td>
        <input type="text" name = "a_pass" value="${AdminVO.a_pass }">
        </td>
     </tr>
      <tr>
         <th>이메일</th>
         <td>
         <input type="text" name = "a_email" value="${AdminVO.a_email }">
         </td>
     </tr>
     <tr>
         <th>이름</th>
         <td>
         <input type="text" name = "a_name" value="${AdminVO.a_name }">
         </td>
     </tr>
     </table>
    </div>
    <input type="submit" value="확인" onclick="">
  </form>
</body>
</html>