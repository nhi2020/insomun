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
	function delReview() {
		/* alert(document.frm.chk.length); */
		document.frm.action="/shop/mng/seller/delMngSeller.do";
		document.frm.submit();
	}
</script>

</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>


<div class="container">
		<div class="row">
			
			
			<form action="/shop/mng/seller/listMngSeller.do">
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="아이디"
						aria-label="Username" aria-describedby="basic-addon1"
						name="searchWrd">
					<div class="input-group-append">
						<input class="btn btn-secondary" type="submit" value="검색" />
					</div>
				</div>
			<input type="hidden" name="pageIndex" value="${searchVO.pageIndex }" />
			<input type="hidden" name="searchCnd" value="0" />
			</form>
			
			
 <input type="button" value="회원등록" onclick="location.href='/shop/mng/seller/InsertMngSellerForm.do'"> 
 <input type="button" value="(체크박스)전환" onclick="delReview();">
 
				<form name="frm" id="frm">
			<table class="table mx-auto">
				<tr>
					<th>체크박스</th>
					<th>번호</th>
					<th>판매자 아이디</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>판매자 사진</th>
					<th>핸드폰 번호</th>
					<th>주소</th>
					<th>성별</th>
					<th>수정일</th>
					<th>등록일</th>
					<th>생년월일</th>
					<th>판매자 상태여부</th>	
					<th>상태 변경</th>		
					<th>강제 로그인</th>
				</tr>
				
				
				<c:forEach items="${list }" var="s_list" varStatus="status">
					<tr>
						<td><input type="checkbox" name="chk" id="chk" value="${s_list.s_idx }"></td>
						<td>${s_list.s_idx }</td>
						<td><a href="/shop/mng/seller/updateMngSellerForm.do?s_id=${s_list.s_id }">${s_list.s_id }</a></td>
						<td>${s_list.s_nickname }</td>
						<td>${s_list.s_email }</td>
						<td>
						<img src="<c:url value='/'/>file/${s_list.s_photo}" width="70" height="50"/>
						<%-- <img alt="회원 사진" src="../../../images/shop/seller/${s_list.s_photo }" width="70" height="50"> --%>
						 </td>
						<td>${s_list.s_phone }</td>
						<td>${s_list.s_addr }</td>
						<td>${s_list.s_gender }</td>
						<td>${s_list.s_moddate }</td>
						<td>${s_list.s_regdate }</td>
						<td>${s_list.s_birth }</td>
						
						<c:choose>
							<c:when test="${s_list.s_status eq 'Y'}">
								<td>활동중인 계정</td>
							</c:when>
							<c:when test="${s_list.s_status eq 'N'}">
								<td>탈퇴된 계정</td>
							</c:when>
						</c:choose>	
						<td><input type="submit" value="전환" form="frm${status.index }"></td>
						<td><input type="button" value="강제로그인" onclick="location.href='/shop/user/seller/EgovsellerLoginPro.do?id=${s_list.s_id}&passwd=${s_list.s_pass }'" /></td>
						</tr>
				</c:forEach>
						<tr>
						<td></td>
						</tr>
			</table>
			</form>
			<c:forEach items="${list }" var="s_list" varStatus="status">
				<form id="frm${status.index }" action="updateMngSellerStateChange.do">
					<input type="hidden" name="s_id" value="${s_list.s_id }">
					<input type="hidden" name="pageIndex" value="${paginationInfo.currentPageNo }">
				</form>
			</c:forEach>		
			
			<div id="paging_div">
				<ul class="paging_align">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="fn_egov_select_productList" />
				</ul>
			</div>
		</div>
	</div>


</body>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>