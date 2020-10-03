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
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/";
			})
			
			$("#submit").on("click", function(){
				if($("#s_id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#s_id").focus();
					return false;
				}
				if($("#s_pass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#s_pass").focus();
					return false;
				}
				if($("#s_pass2").val()==""){
					alert("비밀번호재확인를 입력해주세요.");
					$("#s_pass2").focus();
					return false;
				}
				if($("#s_pass").val() != $("#s_pass2").val()){
					alert("비밀번호가 일치하지 않습니다.");
					$("#s_pass").focus();
					return false;
				}
				if($("#s_nickname").val()==""){
					alert("성명을 입력해주세요.");
					$("#s_nickname").focus();
					return false;
				}
				if($("#s_addr").val()==""){
					alert("주소을 입력해주세요.");
					$("#s_addr").focus();
					return false;
				}
				if($("#s_email").val()==""){
					alert("이메일을 입력해주세요.");
					$("#s_email").focus();
					return false;
				}
				if($("#s_phone").val()==""){
					alert("핸드폰 번호을 입력해주세요.");
					$("#s_phone").focus();
					return false;
				}
				if($("#s_birth").val()==""){
					alert("생년월일을 입력해주세요.");
					$("#s_birth").focus();
					return false;
				}
				var idChkVal = $("#idChk").val();
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
					return false;
				}else if(idChkVal == "Y"){
					$("#regForm").submit();
				}else if(idChkVal == "D"){
					alert("중복된 아이디입니다.");
					return false;
				}
			});
		})
		
		function fn_idChk(){
			$.ajax({
				url : "/shop/user/seller/sellerIdChk.do",
				type : "post",
				dataType : "json",
				data : {"s_id" : $("#s_id").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
						$("#idChk").attr("value", "D");
						$("#s_id").focus();
						
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
					}
				}
			})
		}
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
							<button class="idChk" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button>
							
							<input type="password" class="form-control" id="s_pass" name="s_pass" placeholder="비밀번호">
							<input type="password" class="form-control" id="s_pass2" name="s_pass2" placeholder="비밀번호재확인">
							<input type="text" id="s_nickname" class="form-control" name="s_nickname" placeholder="닉네임">
							 <input type="text" id="s_addr" name="s_addr" placeholder="주소">
							<input type="text" class="form-control" id="s_email" name="s_email" placeholder="이메일">
							<input type="text" class="form-control" id="s_phone" name="s_phone" placeholder="핸드폰 번호">
							<input type="date" class="form-control" id="s_birth" name="s_birth" placeholder="생년월일">
							<input type="text" class="form-control" id="s_account" name="s_account" placeholder="계좌번호">
					<label class="form-check-label" for="gender"> 
							<input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="남자" checked="checked">남
						</label>
					</div>
					<div class="form-check-inline">
					<label class="form-check-label" for="gender"> 
						<input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="여자">여
					</label> 
					
						<input class="btn btn-success" type="submit" id="submit" value="회원가입">
					</div>
				</div>
				</div>
			</form>
		</div>
	</div>
	</div>
	
</html>
</body>
</html>