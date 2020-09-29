<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm">
				<p>
					<button class="btn btn-primary"
						onclick="location.href='/shop/user/buyer/updateUserBuyerForm.do'">정보수정
					</button>
				</p>
				<p>
					<button class="btn btn-primary">장바구니</button>
				</p>
				<p>
					<button class="btn btn-primary">거래현황</button>
				</p>
				<p>

					<button class="btn btn-primary">거래후기</button>
				</p>
				<p>

					<button class="btn btn-primary">거래내역</button>
				</p>
				<p>
					<button class="btn btn-primary">찜한상품</button>
				</p>
			</div>
			<div class="col-9">
				<table class="table mx-auto">
					<tr>
						<td>SNS IDX</td>
						<td>${BuyerVO.sns_idx }</td>
					</tr>
					<tr>
						<td>USERID</td>
						<td>${BuyerVO.userid }</td>
					</tr>
					<tr>
						<td>SNSCODE</td>
						<td>${BuyerVO.snscode }</td>
					</tr>
					<tr>
						<td>NICKNAME</td>
						<td>${BuyerVO.nickname }</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>