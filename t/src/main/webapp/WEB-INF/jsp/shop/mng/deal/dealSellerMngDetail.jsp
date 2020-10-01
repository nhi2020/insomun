<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>거래</h1><p1>
<h4>판매자</h4><p1>
거래상태 : ${dealREsult.d_ing}<br>
구매자${dealREsult.sns_idx }${dealREsult.평가?}가<br>
${dealREsult.p_name } ${dealREsult.d_q } 개 구매 하였습니다.<br>
주소는 ${dealREsult.addr }입니다.<br>
<%-- 주소는 ${list.addr }이며,
배송 요청사항은 ${list.요청사항 }입니다. --%>
거래 진행 시 아래 거래 진행을 클릭하여 주시고,<br>
사정에 의해서 거래 파기시 아래 거래 파기를 클릭해 주시기 바랍니다.<br>
구매자와 입금 확인 및 상품 전달 완료 시 거래 완료 클릭해 주시기 바랍니다.<br>



거래진행<br>
거래파기<br>
거래완료<br>
</body>
</html>