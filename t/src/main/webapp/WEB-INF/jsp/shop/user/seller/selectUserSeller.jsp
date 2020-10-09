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

<style type="text/css">

 #nav {
            display: flex;
            height: 100px;
            background-color: grey;
            color: white;
        }
 .menu-item {
            font-size: 24px;
            padding: 5px 23px;
            display: flex;
            align-items: center;
        }
   
</style>
</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	
	<h5 style="color: grey; text-align: center; margin-top: 50px">입소문넷 회원 ${SellerVO.s_nickname}님 안녕하세요!</h5>
	
	<div class="w-auto p-3">

	
	<div id="nav">
        <div class="menu-item" id="item8"><input type="button" class="btn btn-light" onclick="location.href='/shop/mng/seller/updateMngSellerForm.do?s_id=${SellerVO.s_id}'" value="정보수정"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/deal/dealUserSellerList.do'" value="신청대기중인 거래보기"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/deal/dealUserSellerList.do'" value="수락한 거래보기"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/deal/dealUserSellerList.do'" value="구매확정 거래보기"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/deal/dealUserSellerList.do'" value="취소된 거래보기"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/user/product/EgovUserProductInsertForm.do'" value="거래추가"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/mng/review/MngSelect.do'" value="리뷰관리"></div>
        <div class="menu-item" id="item10"><input type="button" class="btn btn-light" onclick="location.href='/shop/mng/review/MngSelect.do'" value="달린댓글"></div>

    </div>
    
    
	<p>
	
	
	 <div>
            <h1>신청대기중인 거래보기...</h1>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel, tempore dicta ut voluptate asperiores doloremque sapiente odit iste? Totam id, labore aut eligendi ullam doloremque officiis iure expedita suscipit perspiciatis.</p>
		<p><a href="/shop/user/deal/dealUserSellerList.do">자세히...</a></p>
	</div>
	
	<p>
	
	<div>
			<h1>수락한 거래보기...</h1>
        <p>Doloribus repudiandae sint enim, rerum dolorum ratione quis aspernatur deleniti excepturi, illum temporibus eveniet facilis cupiditate quaerat deserunt debitis ipsa ad illo assumenda minima. Facilis explicabo atque quasi eius dolorem!</p>
		<p><a href="/shop/user/deal/dealUserSellerList.do">자세히...</a></p>
	</div>
	
	<p>	
	
	<div>
        	<h1>구매확정 거래보기...</h1>
        <p>Explicabo reiciendis aspernatur, repellat sapiente quae voluptas adipisci quod a ab, mollitia nobis. Facilis reprehenderit quasi eligendi repudiandae, nulla ad repellendus! Provident tempore quidem aliquam maxime dolores exercitationem laudantium consequatur?</p>
		<p><a href="/shop/user/deal/dealUserSellerList.do">자세히...</a></p>
	</div>
		
	<p>	
	
	<div>
			<h1>취소된 거래보기..</h1>
        <p>Voluptas, fuga! Sint quaerat tempore sed alias aperiam vel nisi recusandae. Officia dolorum libero nisi maxime debitis aperiam cumque blanditiis, reiciendis voluptate voluptatibus asperiores saepe inventore odio, molestias, possimus dolorem.</p>
 		<p><a href="/shop/user/deal/dealUserSellerList.do">자세히...</a></p>
	</div>
	
	<p>
	
	<div>
			<h1>리뷰관리...</h1>
        <p>Doloribus repudiandae sint enim, rerum dolorum ratione quis aspernatur deleniti excepturi, illum temporibus eveniet facilis cupiditate quaerat deserunt debitis ipsa ad illo assumenda minima. Facilis explicabo atque quasi eius dolorem!</p>
		<p><a href="/shop/mng/review/MngSelect.do">자세히...</a></p>
	</div>
	
	<p>	
	
	<div>
        	<h1>달린댓글...</h1>
        <p>Explicabo reiciendis aspernatur, repellat sapiente quae voluptas adipisci quod a ab, mollitia nobis. Facilis reprehenderit quasi eligendi repudiandae, nulla ad repellendus! Provident tempore quidem aliquam maxime dolores exercitationem laudantium consequatur?</p>
		<p><a href="/shop/mng/review/MngSelect.do">자세히...</a></p>
	</div>

	</div>
	
<%@ include file="../../inc/EgovShopBottom.jsp" %>
</body>
</html>