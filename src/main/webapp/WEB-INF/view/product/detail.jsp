<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
<h3>상품 상세보기 페이지</h3>
	<form action="/orders/${productId}}" method="post">
		<input id="id" type="hidden" value="${detail.productId}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>상품명</th>
					<th>상품가격</th>
					<th>상품수량</th>
					<th>구매수량</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.qty}</td>
				<td width="150"> <input name="ordersQty" type="number"  min="1" class="form-control"></td>
			</tr>
			</tbody>
		</table>
		<button type="submit" class="btn btn-primary">구매하기</button>
	</form>
	<div class="d-flex">
	<!-- 
		<a href="/product/${detail.productId}/edit" class="btn btn-warning">상품수정</a>
		<form action="/product/${detail.productId}/delete" method="post">
			<button id="btnDelete" type="submit"  class="btn btn-danger">상품삭제</button>
		</form>
		 -->
	</div>
</div>


    <%@ include file="../layout/footer.jsp" %>