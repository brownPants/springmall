<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sampleList</title>
<!-- bootstrap CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-primary text-center">sampleList</h1>
	<a href="${pageContext.request.contextPath}/sample/addSample">
		<button type="button" class="btn btn-success btn-lg">회원가입</button>
	</a>
	<form action="${pageContext.request.contextPath}/sample/sampleList" method="get">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">아이디+비밀번호</span>
			</div> 
			<input type="text" name="searchWord" placeholder="검색" class="form-control">
			<input type="submit" value="검색버튼">
		</div>
	</form>
	<table class="table table-hover">
		<thead class="text-secondary">
			<tr>
				<td>SAMPLE NO</td>
				<td>SAMPLE ID</td>
				<td>SAMPLE PW</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody>
			<!-- model안의 sampleList 가져와서 사용 -->
			<c:forEach var="sample" items="${sampleList}">
				<tr>
					<td class="text-primary">${sample.sampleNo}</td>
					<td>${sample.sampleId}</td>
					<td>${sample.samplePw}</td>
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DELETE</a></td>
					<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-center">
		<ul class="pagination justify-content-center">
			<c:if test="${prevPage}">
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sample/sampleList?searchWord=${searchWord}&currentPage=${(currentBlock - 1) * pagePerBlock}">< 이전</a></li>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${currentPage == i}">
					<li class="page-item"><a class="page-link" href="#">${i}</a></li>
				</c:if>
				<c:if test="${currentPage != i}">
					<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sample/sampleList?searchWord=${searchWord}&currentPage=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${nextPage}">
				<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sample/sampleList?searchWord=${searchWord}&currentPage=${currentBlock * pagePerBlock + 1}">다음 ></a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>