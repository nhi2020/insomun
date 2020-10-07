<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	<div class="container">
		<div class="row">
			<table class="table mx-auto">
				<tr>
					<th>SNS 번호</th>
					<th>유저 아이디</th>
					<th>SNS 코드</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>등록일자</th>
					<th>상태</th>
					<th>상태 변경</th>
					<th>로그인</th>
				</tr>
				<c:forEach items="${list }" var="sns_list" varStatus="status">
					<tr>
						<td><a
							href="/shop/mng/buyer/updateMngBuyerForm.do?sns_idx=${sns_list.sns_idx }">${sns_list.sns_idx }</a></td>
						<td>${sns_list.userid }</td>
						<td>${sns_list.snscode }</td>
						<td>${sns_list.nickname }</td>
						<td>${sns_list.email }</td>
						<td>${sns_list.reg_date }</td>
						<td>${sns_list.del_yn }</td>
						<td><input type="submit" value="전환"
							form="frm${status.index }" /></td>
						<td><input class="btn btn-secondary" type="button" value="로그인" onclick="location.href='/shop/mng/snsprofile/loginMngSnsprofilePro.do?sns_idx=${sns_list.sns_idx}'" /></td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach items="${list }" var="sns_list" varStatus="status">
				<form id="frm${status.index }" action="updateMngBuyerStateChange.do">
					<input type="hidden" name="sns_idx" value="${sns_list.sns_idx }">
					<input type="hidden" name="pageIndex"
						value="${paginationInfo.currentPageNo }">
				</form>
			</c:forEach>
			<form name="frmPage" action="/shop/mng/buyer/listMngBuyer.do">
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="아이디"
						aria-label="Username" aria-describedby="basic-addon1"
						name="searchWrd" value="${searchVO.searchWrd }"> 
					<div class="input-group-append">
						<input class="btn btn-secondary" type="submit" value="검색" />
					</div>
				</div>
			 <input type="hidden" name="pageIndex" value="1" />
				<input type="hidden" name="searchCnd" value="0" />
			</form>
			<div id="paging_div">
				<ul class="paging_align">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="linkPage" />
				</ul>
			</div>
		</div>
	</div>
</body>
<script>
function linkPage(pageIndex){
	document.forms["frmPage"]["pageIndex"].value=pageIndex;
	document.forms["frmPage"].submit();
	return true;
}
</script>
</body>
</html>