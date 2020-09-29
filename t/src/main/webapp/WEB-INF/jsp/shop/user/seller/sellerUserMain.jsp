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
.item {
            flex-basis: 100px;
        }
 #nav {
            display: flex;
            height: 100px;
            background-color: grey;
            color: white;
        }
 .menu-item {
            font-size: 28px;
            padding: 5px 15px;
            display: flex;
            align-items: center;
        }
.menu-item:hover {
            background-color: black;
        }
        
.left-box {
background: rgba(0, 0, 255, 0.1);
  float: left;
  width: 50%;
}
.right-box {
background: rgba(0, 0, 255, 0.1);
  float: right;
  width: 50%;
}
        
</style>
</head>

<body>
	<%@ include file="../../inc/EgovShopTop.jsp"%>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>
	
	<h5 style="color: grey; text-align: center; margin-top: 50px">입소문넷 회원 ${s_id}님 안녕하세요!</h5>
	
	<div class="w-auto p-3">

	
	<div id="nav">
        <div class="menu-item" id="item8"><input type="button" onclick="location.href=''" value="정보수정"></div>
        <div class="menu-item" id="item9"><input type="button" onclick="location.href=''" value="장바구니"></div>
        <div class="menu-item" id="item10"><input type="button" onclick="location.href=''" value="진행중인 거래"></div>
        <div class="menu-item" id="item10"><input type="button" onclick="location.href=''" value="거래추가"></div>
        <div class="menu-item" id="item10"><input type="button" onclick="location.href=''" value="거래후기"></div>
        <div class="menu-item" id="item10"><input type="button" onclick="location.href=''" value="거래내역"></div>
        <div class="menu-item" id="item10"><input type="button" onclick="location.href=''" value="찜한상품"></div>

    </div>
    
    
	<p>
	
	
	 <div class="left-box">
            <h1>내 장바구니...</h1>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vel, tempore dicta ut voluptate asperiores doloremque sapiente odit iste? Totam id, labore aut eligendi ullam doloremque officiis iure expedita suscipit perspiciatis.</p>
		<p><a href="">자세히...</a></p>
	</div>
	
	<p>
	
	<div class="left-box">
			<h1>현재 진행중인 거래...</h1>
        <p>Doloribus repudiandae sint enim, rerum dolorum ratione quis aspernatur deleniti excepturi, illum temporibus eveniet facilis cupiditate quaerat deserunt debitis ipsa ad illo assumenda minima. Facilis explicabo atque quasi eius dolorem!</p>
		<p><a href="">자세히...</a></p>
	</div>
	
	<p>	
	
	<div class="right-box">
        	<h1>내 거래 내역 보기...</h1>
        <p>Explicabo reiciendis aspernatur, repellat sapiente quae voluptas adipisci quod a ab, mollitia nobis. Facilis reprehenderit quasi eligendi repudiandae, nulla ad repellendus! Provident tempore quidem aliquam maxime dolores exercitationem laudantium consequatur?</p>
		<p><a href="">자세히...</a></p>
	</div>
		
	<p>	
	
	<div class="right-box">
			<h1>내 글에 남겨진 거래 후기...</h1>
        <p>Voluptas, fuga! Sint quaerat tempore sed alias aperiam vel nisi recusandae. Officia dolorum libero nisi maxime debitis aperiam cumque blanditiis, reiciendis voluptate voluptatibus asperiores saepe inventore odio, molestias, possimus dolorem.</p>
 		<p><a href="">자세히...</a></p>
	</div>
	

	
</body>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>