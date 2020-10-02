<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../inc/EgovShopTop.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>입소문넷</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>

<body>
<%@ include file="../inc/EgovShopHeader.jsp" %>


<div class="container-fluid">
		<div class="container text-center">
			<h3>${keyword} 검색 결과 </h3>
			<div class="row">
				<c:forEach var="product_list" items="${list2}">
					<div class="col-3">

						<img src="./images/main/photo/${product_list.p_image}" width="270"
							height="385" />

						<p>

							<span>판매자 아이디: ${product_list.s_id }</span> <br /> <span>가격:
								${product_list.p_price }</span> <br /> <span>상태:
								${product_list.p_status }</span> <br /> <span>재고 수량:
								${product_list.p_q }</span> <br /> <span>업데이트된 날짜:
								${product_list.p_moddate }</span>
						</p>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>
<%@ include file="../inc/EgovShopBottom.jsp" %>
</body>
</html>