<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	if(${chk} == 0){
		alert("${msg}");
		location.href='/shop/mng/seller/insertMngSellerForm.do';
		
		
	}else{
		alert("등록 완료");
		location.href='/shop/mng/seller/listMngSeller.do';
	}

</script>

</head>
<body>

</body>
</html>