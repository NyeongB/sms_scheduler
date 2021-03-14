<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<style>
.login {
	text-align: right;
}

hr {
	clear: both;
}
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">




				<br>
				<hr>
				<br>
				<br>


				<p class="lead" style="text-align: right; font-size: xx-large;">회원 정보</p>



				<div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>순번</th>
								<th>이름</th>
								<th>아이디</th>
								<th>전화번호</th>
								<th>내용</th>
								<th>가입일</th>
								<th>활성화</th>
								<th>활성화 버튼</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>최철녕</td>
								<td>ccn_01</td>
								<td>010-9965-****</td>
								<td>기본내용</td>
								<td>2021-03-01</td>
								<td>문자활성화</td>
								<td><button type="button" class="btn">신청</button></td>
							</tr>

						</tbody>
						
					</table>
				</div>


			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>