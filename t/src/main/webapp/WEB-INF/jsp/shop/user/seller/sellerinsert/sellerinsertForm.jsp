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

</script>
</head>
<body>
<div>
	<div class="container">
		<div class="row justify-content-center">
		
		<!-- <form action="/shop/user/EgovUserLoginForm.do" name="frm" method="post"> -->
			<form action="/shop/user/seller/sellerinsertPro.do" name="frm" method="post">
					<h2>회원가입 </h2>
					<div class="form-group">
							<!-- <label for="id">아이디</label> --><div>
							<input type="text" id="s_id" class="form-control" name="s_id" placeholder="아이디">
							<input type="password" class="form-control" id="s_pass" name="s_pass" placeholder="비밀번호">
							<input type="text" id="s_nickname" class="form-control" name="s_nickname" placeholder="닉네임">
							 <input type="text" id="s_addr" name="s_addr" placeholder="주소">
							<input type="text" class="form-control" id="s_email" name="s_email" placeholder="이메일">
							<input type="text" class="form-control" id="s_phone" name="s_phone" placeholder="핸드폰 번호">
							<input type="date" class="form-control" id="s_birth" name="s_birth" placeholder="생년월일">
							<input type="text" class="form-control" id="s_account" name="s_account" placeholder="계좌번호">
					<label class="form-check-label" for="gender"> 
							<input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="M" checked="checked">남
						</label>
					</div>
					<div class="form-check-inline">
					<label class="form-check-label" for="gender"> 
						<input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="W">여
					</label> 
					
						<input type="submit" value="회원가입">
					</div>
				</div>
				</div>
			</form>
		</div>
	</div>
	</div>



</body>
</html>