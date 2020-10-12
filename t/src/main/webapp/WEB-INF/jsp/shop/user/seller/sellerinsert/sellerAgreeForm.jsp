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
 <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
      $( document ).ready( function() {
        $( '.check-all' ).click( function() {
          $( '.ab' ).prop( 'checked', this.checked );
        } );
      } );
      $( document ).ready( function() {
    	 
          $( '.ab' ).click( function() {
        	  
        	  if($("input:checkbox[name=cb1]").is(":checked") == true && $("input:checkbox[name=cb2]").is(":checked") == true){
        		 
        		  $( '.check-all' ).prop( 'checked', this.checked );
        	  }else{
        		  
        		  $('input:checkbox[name=all]').prop('checked', false);

        	  }
          } );
        } );
      $(function() {
          $( '#next' ).click( function() {
        	 
        	  if($("input:checkbox[name=all]").is(":checked") == true){
        		 
        		  location.href = "<c:url value='/shop/user/seller/sellerinsert.do'/>";
        	  }else{
        		  alert("약관의 동의하십시오.")
        	  }
          } );
        } );
      $(function() {
          $( '#back' ).click( function() {
        
        		  location.href = "<c:url value='/shop/user/EgovUserLoginForm.do'/>";
        	  
          } );
        } );
  
    </script>
</head>
<body>
<%@ include file="../../../inc/EgovShopHeader.jsp" %>

 <form>
 <div class="wrap1" style="padding: 50px 40%">
 	
      <p><input type="checkbox" name="all" class="check-all"> <label>전체 동의</label></p>
      
      <p><input type="checkbox" name="cb1" class="ab"> <label>입소문 이용 약관 동의(필수)</label></p>
      <textarea rows="5" cols="30"></textarea><p>
      <p><input type="checkbox" name="cb2" class="ab"> <label>개인정보 수집 및  이용 동의(필수)</label></p>
      <textarea rows="5" cols="30"></textarea><p>
     
 
 </div>    
 </form>
 
<div class="wrap1" style="padding: 10px 40%">
	 <input class="btn btn-secondary" type="submit" id = "back" name= "back" onclick="check1();" value="취소">
	  <input class="btn btn-secondary" type="submit" id = "next" name= "next" onclick="check();" value="다음">
</div>
</body>
</html>