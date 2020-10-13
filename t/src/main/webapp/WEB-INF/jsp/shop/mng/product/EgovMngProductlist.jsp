<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<%@ page
	import="egovframework.let.shop.mng.product.service.impl.ProductMngVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>운영자 상품 관리 페이지입니다</title>

</head>
<body>
	<%@ include file="../../inc/EgovShopHeader.jsp"%>

<!-- result 값을 이용한 modal -->
	<c:if test="${result2 == 0 && result ==null}">
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateModal").modal('show')
			
			})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">항목을 체크해주세요.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	
	<!-- result 값을 이용한 modal -->
	<c:if test="${result1 == 1}">
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateModal").modal('show')
			
			})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">등록되었습니다</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	
	<!-- result 값을 이용한 modal -->
	<c:if test="${result3 == 1 }">
		<script type="text/javascript">
			$(document).ready(function(){
				$("#updateModal").modal('show')
			
			})
		</script>
		<!-- Modal -->
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">수정되었습니다.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	
	<form action="/shop/mng/product/EgovMngProductDelete.do">
	<p/>
	<div align="center">
		<input type="button" value="등록" onclick="location.href='/shop/mng/product/EgovMngProductInsertForm.do'" class="btn btn-primary">
		&nbsp; &nbsp; 
		<input type="submit" value="삭제" class="btn btn-danger">
	</div>
		<p/>
		<div class="container-fluid" >
			<div class="container text-center">
				<div class="row">
					<c:forEach var="product_list" items="${list}">
						<div class="col-3 mt-3">
						<img src="<c:url value='/'/>file/${product_list.p_image}" width="270" height="270" class="rounded"/> 
							<span> <input type="checkbox" name="check" id="check" value="${product_list.p_idx }"> 
							상품명 : ${product_list.p_name }
							</span> <br /> 
							<span>판매자: ${product_list.s_id }</span> <br /> 
							<span>가격 : 
							<fmt:formatNumber value="${product_list.p_price }" pattern="##,###"></fmt:formatNumber></span><br /> 
							<span>상태: ${product_list.p_status }</span> 
							<p/>	
							<input type="button" value="수정" class="btn btn-warning"
							onclick="location.href='/shop/mng/product/EgovMngProductUpdateForm.do?p_idx=${product_list.p_idx}'">							
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
</form>
<div class="container">
	<div class="row">
		<form name="frmPage" class="mx-auto" action="/shop/mng/product/EgovMngProductlist.do">
						<div class="input-group mb-3">
						<input type="hidden" name="pageIndex" value="1" />
						<select name="searchCnd">
							<option value="0">상품명</option>
							<option value="1">판매자</option>
						</select>
							<input type="text" class="form-control" placeholder="검색하세요"
								aria-label="Productname" aria-describedby="basic-addon1"
								name="searchWrd" value="${searchVO.searchWrd }"> 
							<div class="input-group-append">
								<input class="btn btn-secondary" type="submit" value="검색" />
							</div>
						</div>
					 
					</form>
	</div>
				<div class="row">
					<div id="paging_div" class="mx-auto">
						<ul class="paging_align">
							<ui:pagination paginationInfo="${paginationInfo}" type="image"
								jsFunction="linkPage" />
						</ul>
					</div>
				</div>
</div>
	<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
<script>
function linkPage(pageIndex){
	document.forms["frmPage"]["pageIndex"].value=pageIndex;
	document.forms["frmPage"].submit();
	return true;
}
</script>
</html>