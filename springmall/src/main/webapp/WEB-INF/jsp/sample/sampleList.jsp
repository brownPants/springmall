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
	<div>
		<a href="<%=request.getContextPath()%>/sample/addSample">
			<button type="button" class="btn btn-success btn-lg">회원가입</button>
		</a>
	</div>
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
	<div>
		<c:if test="${currentPage>1}">
			<a href="<%=request.getContextPath()%>/sample/sampleList?currentPage=${currentPage-1}">
				<button type="button" class="btn btn-light btn-lg">이전</button>
			</a>
		</c:if>
		<c:if test="${currentPage<lastPage}">
			<a href="<%=request.getContextPath()%>/sample/sampleList?currentPage=${currentPage+1}">
				<button type="button" class="btn btn-light btn-lg">다음</button>
			</a>
		</c:if>
	</div>
</body>
</html>