<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifySample</title>
<!-- bootstrap CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script>
	$(document).ready(()=>{
		$('#samplePw').focus();
		$('#samplePw').blur(()=>{
			if($('#samplePw').val().length < 4) {
				$('#modifySampleHelp').text('비밀 번호(4자 이상)를 입력하세요');
				$('#samplePw').focus();
			} else {
				$('#modifySampleHelp').text('');
			}
		});
		$('#modifyBtn').click(()=>{
			 if($('#samplePw').val().length < 4) {
				 $('#samplePw').focus();
			 } else {
				 $('#modifyForm').submit(); 
			 }
		});
	});
</script>
</head>
<body class="container">
	<h2 class="text-primary text-center">modifySample Form</h2>
	<div class="text-center">
        <span id="modifySampleHelp" class="text-danger"></span>
    </div>
	<form id="modifyForm" action="${pageContext.request.contextPath}/sample/modifySample" method="post">
		<input type="hidden" name="sampleNo" value="${sample.sampleNo}" class="form-control">
		<table class="table table-hover">
			<tr>
				<td><input type="text" id="sampleId" name="sampleId" value="${sample.sampleId}" placeholder="아이디" readonly class="form-control"></td>
			</tr>
			<tr>
				<td><input type="password" id="samplePw" name="samplePw" value="${sample.samplePw}" placeholder="비밀번호" class="form-control"></td>
			</tr>
		</table>
		<div class="text-center">
			<a href="${pageContext.request.contextPath}/sample/sampleList">
				<button type="button" class="btn btn-light btn-lg">취소</button>
			</a>
			<button id="modifyBtn" type="button" class="btn btn-success btn-lg">정보수정</button>
		</div>
	</form>
</body>
</html>