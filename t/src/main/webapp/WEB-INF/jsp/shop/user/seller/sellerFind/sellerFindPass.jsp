
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%@ include file="../../../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
function check() {
	location.href = "<c:url value='/shop/user/EgovUserLoginForm.do'/>";
}
</script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<form id="fm" name="fm" action="/user2/help/pwInquiry.nhn?m=actionInputPasswd" method="post">			
			<div class="section section_find">
					<dl class="n_id">
					<dt>아이디 : ${s_id }</dt>
					</dl>
						<label id="lb_new_pw" for="new_pw" style="">새 비밀번호</label>					
						<input id="s_pass" name="s_pass" type="password"><br>
						<label id="lb_new_pw" for="new_pw" style="">새 비밀번호 확인</label>					
						<input id="s_pass2" name="s_pass2" type="password">

				<div class="btn_area">
					<a href="#" id="changeSubmit" onclick="check();" class="btn_confirm2"><span class="blind">확인</span></a>
				</div>
			</div>
</form>
</body>
</html>