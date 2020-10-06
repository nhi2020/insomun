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
			 $("#s_id").blur(function() {
		            idFlag = false;
		            fn_idChk("first");
		        });
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/";
			})
			
			$("#submit").on("click", function(){
				//이메일 정규식
				var emailAdd1 = document.getElementById('email1').value; 
	               var emailAdd2 = document.getElementById('email2').value;

	               var emailAddress = emailAdd1 + "@" + emailAdd2;
	               var eregExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	              
	               var pregExp = /^\d{2,3}-\d{3,4}-\d{4}$/;

				if($("#s_id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#s_id").focus();
					return false;
				}
				if($("#s_name").val()==""){
					alert("이름을 입력해주세요.");
					$("#s_name").focus();
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
				if($("#sample6_address").val()==""){
					alert("주소를 입력해주세요.");
					$("#sample6_address").focus();
					return false;
				}
				if($("#sample6_detailAddress").val()==""){
					alert("상세주소를 입력해주세요.");
					$("#sample6_detailAddress").focus();
					return false;
				}
				if($("#email1").val()==""){
					alert("이메일을 입력해주세요.");
					$("#email1").focus();
					return false;
				}
				if($("#email2").val()==""){
					alert("이메일을 입력해주세요.");
					$("#email2").focus();
					return false;
					}
				if ( !emailAddress.match(eregExp) ) {
	            	   alert("이메일형식이 맞지 않습니다.");
	            	   $("#email2").focus();
	            	 return false;
	               } 
				
				if($("#s_phone").val()==""){
					alert("핸드폰 번호을 입력해주세요.");
					$("#s_phone").focus();
					return false;
				}
				if(!pregExp.test($("input[id='s_phone']").val())) {            
					alert("핸드폰 번호을 형식에 맞게.");
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
			if(idFlag) return true;
			var oMsg = $("#idMsg");
	        var oInput = $("#id");

	        if ( $("#s_id").val() == "") {
	            showErrorMsg(oMsg,"필수 정보입니다.");
	            setFocusToInputObject(oInput);
	            return false;
	        }
			/* if($("#s_id").val()==""){
				alert("아이디를 입력해주세요.");
				$("#s_id").focus();
				return false;
			} */
			idFlag = false;
			$.ajax({
				url : "/shop/user/seller/sellerIdChk.do",
				type : "post",
				dataType : "json",
				data : {"s_id" : $("#s_id").val()},
				success : function(data){
					if(data == 1){
						showErrorMsg(oMsg, "이미 사용중이거나 탈퇴한 아이디입니다.");
						$("#idChk").attr("value", "D");
						/* $("#s_id").focus(); */
					}else if(data == 0){
						  showSuccessMsg(oMsg, "멋진 아이디네요!");
						$("#idChk").attr("value", "Y");
						
						
					}
					
				}
			})
			return true;
		}
		
		 function showSuccessMsg(obj, msg) {
		        obj.attr("class", "error_next_box green");
		        obj.html(msg);
		        obj.show();
		    }
		 function showErrorMsg(obj, msg) {
		        obj.attr("class", "error_next_box");
		        obj.html(msg);
		        obj.show();
		    }
	</script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- <script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

             
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
              /*   document.getElementById('sample6_postcode').value = data.zonecode; */
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>

</head>
<body>


<div>
	<div class="container">
		<div class="row justify-content-center">
		
		<!-- <form action="/shop/user/EgovUserLoginForm.do" name="frm" method="post"> -->
			<form action="/shop/user/seller/sellerinsertPro.do" name="frm" method="post">
			<input type="hidden" value="" name="s_addr">
					<h2>회원가입 </h2>
					<div class="form-group">
							<!-- <label for="id">아이디</label> --><div>
							<div class="join_row">
							<input type="text" id="s_id" name="s_id" placeholder="아이디"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<!-- <button class="idChk" type="hidden" id="idChk" onclick="fn_idChk();" value="N">중복확인</button><br> -->
							<div class="join_row">
							<input type="text" id="s_name" name="s_name" placeholder="이름"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type="password"  id="s_pass" name="s_pass" placeholder="비밀번호"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type="password"  id="s_pass2" name="s_pas2s" placeholder="비밀번호 재확인"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type="text"  name="s_nickname" placeholder="닉네임"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type="text" id="sample6_address" name="addr1" placeholder="주소" readonly>
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<input type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type='text' id='email1' name="email1"/> @ <input type='text' id='email2' name="email2"/>
							<button class="idChk" type="button" id="idChk" onclick="fn_emChk();" value="N">이메일 중복확인</button><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type="text"  id="s_phone" name="s_phone" placeholder="01X-XXXX-XXXX"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<div class="join_row">
							<input type="date"  id="s_birth" name="s_birth" placeholder="생년월일"><br>
							<span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span><br>
							</div>
							<select name="s_account_n">
								<option value="null">은행선택</option>
								<option value="신한은행(구)">신한은행(구)</option>
								<option value="신한은행(신)">신한은행(신)</option>
								<option value="국민은행">국민은행</option>
								<option value="우리은행">우리은행</option>
								<option value="기업은행">기업은행</option>
								<option value="하나은행">하나은행</option>
							</select><br>
							<input type="text"  id="s_account" name="s_account" placeholder="계좌번호"><br>
							<label class="form-check-label" for="gender"> 
							<input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="남자" checked="checked">남&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" class="form-check-input" id="s_gender" name="s_gender" value="여자">여
						</label>
					</div>
					<input type="file"  id="S_PHOTO" name="S_PHOTO"><br>
					<div class="form-check-inline">
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