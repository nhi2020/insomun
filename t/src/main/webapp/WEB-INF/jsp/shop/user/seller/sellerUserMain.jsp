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

</style>
</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	
	<h5 style="color: grey; text-align: center; margin-top: 50px">입소문넷 회원 ${s_id}님 안녕하세요!</h5>
	
	<div class="w-auto p-3">
        <table class="table table-striped table-dark p2">
            <thead>
                <tr>
                    <th><input type="button" onclick="location.href=''" value="정보수정"></th>
                    <th><input type="button" onclick="location.href=''" value="장바구니"></th>
                    <th><input type="button" onclick="location.href=''" value="진행중인 거래"></th>
                    <th><input type="button" onclick="location.href=''" value="거래추가"></th>
                    <th><input type="button" onclick="location.href=''" value="거래후기"></th>
                    <th><input type="button" onclick="location.href=''" value="거래내역"></th>
                    <th><input type="button" onclick="location.href=''" value="찜한상품"></th>
                </tr>
            </thead>
          </table>
	
	
	
	
	
	
</body>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>