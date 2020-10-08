<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
function inputPhoneNumber(obj) {



    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";



    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}
</script>

</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>



	<c:if test="${msg != null }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${msg = null }">
	</c:if>
	<div class="container">
		<div class="row">
			<form class="mx-auto" action="/shop/mng/seller/updateMngSellerPro.do" method="post">
				<input type="hidden" name="s_id" value="${SellerVO.s_id }" />

				<table class="table">				
				
					<tr>
						<th>사진</th>
						<td>${SellerVO.s_photo }</td>
					</tr>

					<tr>
						<th></th>
						<td><!-- <input type="file" name="file"> --></td>
					</tr>

					<tr>
						<th>회원아이디</th>
						<td>${SellerVO.s_id }</td>
					</tr>
			
					<tr> 
						<th>닉네임</th>
						<td><input type="text" name="s_nickname"
							value="${SellerVO.s_nickname }" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" name="s_email" value="${SellerVO.s_email }" /></td>
					</tr>
					<tr>
						<th>상태</th>
						<c:choose>
							<c:when test="${SellerVO.s_status eq 'Y'}">
								<td>활동중인 계정</td>
							</c:when>
							<c:when test="${SellerVO.s_status eq 'N'}">
								<td>탈퇴된 계정</td>
							</c:when>
						</c:choose>	
					</tr>
					<tr>
						<th></th>
						<td><input type="radio" name="s_status" value="Y"
							${SellerVO.s_status eq 'Y' ? "checked = 'checked'" : '' } />활동중인 계정
							<input type="radio" name="s_status" value="N" 
							${SellerVO.s_status eq 'N' ? "checked = 'checked'" : '' } />탈퇴된 계정
						</td>
					</tr>
					<tr>
						<th>핸드폰 번호</th>
						<td><input type="text" maxlength="13" onKeyup="inputPhoneNumber(this);" name="s_phone" value="${SellerVO.s_phone }" />
                     	 </td>
							
							
					</tr>
					<tr>
						<th>은행</th>
						<td>
						<select name="s_account_n" value="${SellerVO.s_account_n }">
							<option value="국민은행" ${SellerVO.s_account_n eq '국민은행' ? "selected='selected'" : '' }>국민은행</option>
							<option value="농협은행" ${SellerVO.s_account_n eq '농협은행' ? "selected='selected'" : '' }>농협은행</option>
							<option value="기업은행" ${SellerVO.s_account_n eq '기업은행' ? "selected='selected'" : '' }>기업은행</option>
							<option value="국민은행" ${SellerVO.s_account_n eq '국민은행' ? "selected='selected'" : '' }>국민은행</option>
							<option value="카카오뱅크" ${SellerVO.s_account_n eq '카카오뱅크' ? "selected='selected'" : '' }>카카오뱅크</option>
							<option value="신한은행" ${SellerVO.s_account_n eq '신한은행' ? "selected='selected'" : '' }>신한은행</option>
							<option value="하나은행" ${SellerVO.s_account_n eq '하나은행' ? "selected='selected'" : '' }>하나은행</option>
							<option value="우리은행" ${SellerVO.s_account_n eq '우리은행' ? "selected='selected'" : '' }>우리은행</option>
							<option value="sc제일은행" ${SellerVO.s_account_n eq 'sc제일은행' ? "selected='selected'" : '' }>sc제일은행</option>
							<option value="우체국은행" ${SellerVO.s_account_n eq '우체국은행' ? "selected='selected'" : '' }>우체국은행</option>
							<option value="케이뱅크" ${SellerVO.s_account_n eq '케이뱅크' ? "selected='selected'" : '' }>케이뱅크</option>
							<option value="저축은행" ${SellerVO.s_account_n eq '저축은행' ? "selected='selected'" : '' }>저축은행</option>
						</select>
					</tr>
					<tr>
						<th>계좌 번호</th>
						<td><input type="text" name="s_account" value="${SellerVO.s_account }" /></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="s_addr" value="${SellerVO.s_addr }" /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${SellerVO.s_gender }</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${SellerVO.s_regdate }</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-secondary"  value="수정" /> 
						<input type="button" value="목록으로" class="btn btn-secondary"  onclick="location.href='/shop/mng/seller/listMngSeller.do'" />
						<input type="button" value="강제 로그인" class="btn btn-secondary" onclick="location.href='/shop/user/seller/EgovsellerLoginPro.do?id=${SellerVO.s_id}&passwd=${SellerVO.s_pass }'">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
