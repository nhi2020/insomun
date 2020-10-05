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
	var s_name = $("#s_name").val();
	var s_email = $("#s_email").val();
	if($("#s_name").val()==""){
		alert("아이디를 입력해주세요.");
		$("#s_name").focus();
		return false;
	}
	if($("#s_email").val()==""){
		alert("이메일을 입력해주세요.");
		$("#s_email").focus();
		return false;
	}
	if($("#s_agreenum").val()==""){
		alert("인증번호를 입력해주세요.");
		$("#s_agreenum").focus();
		return false;
	}
	$.ajax({
		url : "/shop/user/seller/sellerCertificationNumberchk.do",
		type : "post",
		dataType : "json",
		data : {"s_name" : $("#s_name").val(),"s_email" : $("#s_email").val(),"s_agreenum" : $("#s_agreenum").val()},
		success : function(data){
			if(data == 1){
				alert("인증되었습니다.");
				location.href="/shop/user/seller/sellerFindId.do?s_name=${s_name}&s_email=${s_email}";
			}else if(data == 0){
				alert("인증번호가 틀립니다.");
			}
		}
	})
	
	

};

/* $(document).ready(function(){
	// 취소
	$(".cencle").on("click", function(){
		location.href = "/";
	})
	
	$("#submit").on("click", function(){

           if($("#s_name").val()==""){
       		alert("아이디를 입력해주세요.");
       		$("#s_name").focus();
       		return false;
       	}
       	if($("#s_email").val()==""){
       		alert("이메일을 입력해주세요.");
       		$("#s_email").focus();
       		return false;
       	}
       	if($("#s_agreenum").val()==""){
       		alert("인증번호를 입력해주세요.");
       		$("#s_agreenum").focus();
       		return false;
       	}
    	$.ajax({
    		url : "/shop/user/seller/sellerCertificationNumberchk.do",
    		type : "post",
    		dataType : "json",
    		data : {"s_name" : $("#s_name").val(),"s_email" : $("#s_email").val(),"s_agreenum" : $("#s_agreenum").val()},
    		success : function(data){
    			if(data == 1){
    				alert("인증되었습니다.");
    				
    			}else if(data == 0){
    				alert("인증번호가 틀립니다.");
    				return false;
    			}
    		}
    	})
	});
}); */

function email(){
	if($("#s_name").val()==""){
		alert("이름을 입력해주세요.");
		$("#s_name").focus();
		return false;
	}
	if($("#s_email").val()==""){
		alert("이메일을 입력해주세요.");
		$("#s_email").focus();
		return false;
	}
	$.ajax({
		url : "/shop/user/seller/sellerCertificationNumber.do",
		type : "post",
		dataType : "json",
		data : {"s_name" : $("#s_name").val(),"s_email" : $("#s_email").val()},
		success : function(data){
			if(data == 1){
				alert("이메일 전송되었습니다..");
				$("#s_agreenum").focus();
				
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
<%@ include file="../../../inc/EgovShopHeader.jsp" %>
<!-- <form action="/shop/user/seller/sellerFindId.do"> -->
<div class="container"	style="text-align:center;">
	<div class="container" style="text-align:left;margin-left: 300px">
	
		<p class="dsc">본인확인 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.</p>	
		<dl>
			<dt><label for="emailNm" class="label_txt">이름</label></dt>
			<dd><input type="text" id="s_name" name="s_name" maxlength="40" class="input_txt" style="width:217px"></dd>
			<dt><label for="email" class="label_txt">이메일 주소</label></dt>
			<dd>
				<input type="text" id="s_email" name="s_email" maxlength="100" class="input_txt" style="width:217px">
				<a href="#" id="btnEmailAuthNo" name="btnEmailAuthNo" onClick="email();" class="btn_ct"><span class="blind">인증번호 받기</span></a>
			</dd>
			<dt><label for="t_ct1" class="blind">인증번호 입력</label></dt>
			<dd class="ct">
				<span class="input_box2">
				<span id="span_emailAuthNo" >인증번호 6자리 숫자 입력</span>
				<input type="text" id="s_agreenum" name="s_agreenum" maxlength="6" style="width:217px">
				</span>								
			</dd>	
		</dl>
	</div>
	<button class="btn btn-secondary" type="submit" onclick="check();">다음</button>
	<!--  <input class="btn btn-success" type="submit" id="submit" value="다음">	-->	

</div>
<!-- </form> -->
</body>
</html>