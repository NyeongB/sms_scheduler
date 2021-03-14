<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$(".btnDelete").click(
			function()
			{
				// 확인
				//alert($(this).val());

				var mid = $(this).val();

				if (confirm(mid + "활성화 상태를 변경하시겠습니까?"))
				{
					//$(location).attr("href","memberdelete.action?mid="+mid);
					$(location).attr(
							"href",
							"onoff?id="
									+ $(this).val());
				}
				//$(location).attr("href","memberdelete.action?mid="+$(this).val());
				//$(location).attr("href","memberdelete.action");
			});

	
	
});
</script>

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
				<br> <br>


				<p class="lead" style="text-align: right; font-size: xx-large;">회원
					정보</p>



				<div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>순번</th>
								<th>이름</th>
								<th>아이디</th>
								<th>전화번호</th>
								<th>내용</th>
								<th>남은금액</th>
								<th>남은횟수</th>
								<th>가입일</th>
								<th>활성화</th>
								<th>활성화 버튼</th>
							</tr>
						</thead>
						<c:forEach var="tmp" items="${list}">
						<tbody>
							<tr>
								<td>${tmp.num }</td>
								<td>${tmp.name }</td>
								<td>${tmp.id }</td>
								<td>${tmp.phone }</td>
								<td>${tmp.content }</td>
								<td>${tmp.total } 원</td>
								<td>${tmp.count } 회</td>
								<td>${tmp.date }</td>
								<td>${tmp.onoff }</td>
								<td><button type="button" class="btn btnDelete" value="${tmp.id }">신청</button></td>
							</tr>

						</tbody>
						</c:forEach>

					</table>
				</div>


			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>