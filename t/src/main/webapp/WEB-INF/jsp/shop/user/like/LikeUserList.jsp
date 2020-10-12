<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%@ include file="../../inc/EgovShopTop.jsp" %>
  <%@ include file="../../inc/EgovShopHeader.jsp" %>
  <div class="container">
    <div class="row">
    
      <table class="table mx-auto">
       <tr>
         <th>등록번호</th>
         <th>상품이미지</th>
         <th>상품이름</th>
         <th>등록일자</th>
         <th>삭제</th>
        </tr>
        <c:forEach items="${list }" var="like_list" >
        <tr>
        <input type="hidden" name="p_idx" value="${like_list.p_idx }" />
          <td>${like_list.l_idx }</td>  
          <td><a href="/shop/user/product/EgovBuyerProductForm.do?p_idx=${like_list.p_idx}"><img src="<c:url value='/'/>file/${like_list.p_image}" width="200" height="200"/></a></td>
          <td>${like_list.p_name }</td>
          <td>${like_list.l_regdate }</td>
          <td><input type="checkbox" name="p_idx" value="${like_list.p_idx }"></td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  <input type="submit" value="삭제">
</body>
</html>