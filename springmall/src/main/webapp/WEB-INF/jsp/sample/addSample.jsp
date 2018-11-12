<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addSample</title>
<!-- bootstrap CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script>
	$(document).ready(()=>{
		$('#sampleId').focus();
		$('#sampleId').blur(()=>{
			if($('#sampleId').val().length < 4) {
				$('#addSampleHelp').text('아이디(4자 이상)를 입력하세요');
				$('#sampleId').focus();
			} else {
				$('#addSampleHelp').text('');
			}
		});
		$('#samplePw').blur(()=>{
			if($('#samplePw').val().length < 4) {
				$('#addSampleHelp').text('비밀 번호(4자 이상)를 입력하세요');
				$('#samplePw').focus();
			} else {
				$('#addSampleHelp').text('');
			}
		});
		$('#addBtn').click(()=>{
			 if($('#sampleId').val().length < 4) {
				 $('#sampleId').focus();
			 } else if($('#samplePw').val().length < 4) {
				 $('#samplePw').focus();
			 } else {
				 $('#addForm').submit(); 
			 }
		});
	});
</script>
</head>
<body class="container">
	<h2 class="text-primary text-center">addSample Form</h2>
	<div class="text-center">
        <span id="addSampleHelp" class="text-danger"></span>
    </div>
	<form id="addForm" action="${pageContext.request.contextPath}/sample/addSample" method="post" enctype="multipart/form-data">
		<table class="table table-hover">
			<tr>
				<td><input type="text" id="sampleId" name="sampleId" placeholder="아이디" class="form-control"></td>
			</tr>
			<tr>
				<td><input type="password" id="samplePw" name="samplePw" placeholder="비밀번호" class="form-control"></td>
			</tr>
			<tr>
				<td><input type="file" id="multipartFile" name="multipartFile" placeholder="파일" class="form-control"></td>
			</tr>
		</table>
		<div class="text-center">
			<a href="${pageContext.request.contextPath}/sample/sampleList">
				<button type="button" class="btn btn-light btn-lg">취소</button>
			</a>
			<button id="addBtn" type="button" class="btn btn-success btn-lg">회원가입</button>
		</div>
	</form>
</body>
</html>