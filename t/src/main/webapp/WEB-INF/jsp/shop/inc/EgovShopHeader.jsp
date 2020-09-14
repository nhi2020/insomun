<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnlogin").click(function(){	
			location.href = "/shop/user/EgovUserLoginForm.do";
		});
	});
	$(document).ready(function(){
		$("#btnlogout").click(function(){	
			var snscode='${sessionScope.snscode}';
			var access_token='${sessionScope.access_token}';
			if(snscode=='kakao'){
				location.href = "https://kauth.kakao.com/oauth/logout?client_id=7e2a4e5240c656b96978c81a1a99fa2a&logout_redirect_uri=http://xn--z92bt9ibqf.net/shop/user/EgovUserLogout.do";
			}else if(snscode=='naver'){
				//location.href = "https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=7e2a4e5240c656b96978c81a1a99fa2a&client_secret=SiffbMIVyj&access_token="+access_token+"&service_provider=NAVER";
				//winpop=open("https://nid.naver.com/nidlogin.logout");
				location.href ="http://xn--z92bt9ibqf.net/shop/user/EgovUserLogout.do";
				//winpop.self.close();
			}
		});
	});
</script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="/shop/product/EgovMngMain.do">Logo</a>

	<!-- Links -->
	<ul class="navbar-nav">
	  <li class="nav-item">
	    <a class="nav-link" href="#">Link 1</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="#">Link 2</a>
	  </li>
	
	  <!-- Dropdown -->
	  <li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	      Dropdown link
	    </a>
	    <div class="dropdown-menu">
	      <a class="dropdown-item" href="#">Link 1</a>
	      <a class="dropdown-item" href="#">Link 2</a>
	      <a class="dropdown-item" href="#">Link 3</a>
	    </div>
	  </li>
	</ul>
	<form class="form-inline" action="/action_page.php">
	  <input class="form-control mr-sm-2" type="text" placeholder="Search">
	  <button class="btn btn-success" type="submit">Search</button>
	</form>
	
	<c:choose>
		<c:when test="${sessionScope.userid eq 'admin'}">
			<div class="container">
				<button type="button" id="#adminpage">admin</button>
			</div>
		</c:when>
	
		 <c:when test="${sessionScope.userid != null and sessionScope.userid ne ' ' }">
		 	<div class="container">
				 <button type="button" id="btnlogout">logout</button>
			 </div>
		</c:when>
		
		<c:otherwise>
			<button type="button" id="btnlogin" class="btn btn-info">login</button>
			<button type="button" id="btnlogout" class="btn btn-info">logout</button>
			<button type="button" id="btnSignIn" class="btn btn-danger" >회원가입</button>
		</c:otherwise>
</c:choose>
</nav>
</body>
</html>