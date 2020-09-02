<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import="egovframework.com.cmm.LoginVO"%>
<%@ include file="../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
td, tr {
	padding: 10px;
}
</style>
</head>
<body>
	<table>
		<c:forEach items="${list }" var="sns_list">
			<tr>
				<td>${sns_list.sns_idx }</td>
				<td>${sns_list.userid }</td>
				<td>${sns_list.snscode }</td>
				<td>${sns_list.nickname }</td>
				<td>${sns_list.email }</td>
				<td>${sns_list.reg_date }</td>
				<td>${sns_list.del_yn }</td>
			</tr>
		</c:forEach>
	</table>
		<div id="paging_div">
		<ul class="paging_align">
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_productList" />
		</ul>
	</div>

</body>
</html>