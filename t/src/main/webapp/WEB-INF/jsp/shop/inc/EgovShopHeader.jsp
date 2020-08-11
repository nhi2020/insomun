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
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">Logo</a>

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
</nav>
</body>
</html>