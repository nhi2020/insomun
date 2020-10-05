<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="egovframework.let.shop.mng.product.service.impl.ProductMngVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>운영자 상품 등록 페이지</title>
</head>

<body>
<%@ include file="../../inc/EgovShopTop.jsp" %>
<%@ include file="../../inc/EgovShopHeader.jsp" %>

  <div class="container-fluid">
	<div class="container text-center">
	    <div class="row">
			<form action="/shop/mng/product/EgovMngProductInsertPro.do" method="post">
				 	<img src="./images/main/photo/" width="270" height="385"/> 
						<p>
					<table class="table">
					<input type="hidden" name="p_idx" id="p_idx" >
					<input type="hidden" name="a_id" id="a_id">
					<tr>
						<th>판매자 아이디</th>				
						<td>
						<input type="text" name="s_id" id="s_id"/>
						</td>
					</tr>	
					 <tr>
						<th>상품명</th>				
						<td>
						<input type="text" name="p_name" id="p_name"/>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
						<input type="text" name="p_price" id="p_price" />
						</td>
					</tr>
				 	<tr>
						<th>등록날짜</th>
						<td>
						<input type="date" name="p_regdate" id="p_regdate" />
						</td>
					</tr>
					<tr>
 					<th>업데이트된 날짜</th>
						<td>
						<input type="date" name="p_moddate" id="p_moddate" />
						</td>
					</tr>
						<tr>
						<th>제품 내용</th>
						<td>
						<textarea rows="5" cols="50" name="p_content" id="p_content"></textarea>
						</td>
					</tr>
					<tr>
						<th>해시태그</th>
						<td>
						<input type="text" name="p_tage" id="p_tage"/>
						</td>
					</tr>
					<tr>
						<th>판매시작일</th>
						<td>
						<input type="date" name="p_sdate" id="p_sdate" />
						</td>
					</tr>
					<tr>
						<th>판매종료일</th>
						<td>
						<input type="date" name="p_edate"  id="p_edate" />
						</td>
					</tr>
					<tr>
						<th>상태</th>
						<td>
						<input type="text" name="p_status" id="p_status" />
						</td>
					</tr>
					<tr>
						<th>재고 수량</th>
						<td>
						<input type="text" name="p_q" id="p_q" />
						</td>
					</tr>  
					<tr> 
						<td colspan="2"><br/>
						<input type="submit" value="등록완료" /> &nbsp;
						<input type="button" value="이전으로" onclick="location.href='/shop/mng/product/EgovMngProductlist.do'"/>
						</td>
					</tr>
				</table>
					<%-- <c:if test=""></c:if> --%>
				</form>				
			</div>
		</div>
	</div>

<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>