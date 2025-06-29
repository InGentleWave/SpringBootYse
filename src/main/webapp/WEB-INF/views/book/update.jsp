<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
<title>책 수정하기</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h2 class="display-4">책 수정하기</h2>
		</div>
	</div>
	<div class="container">
		<form action="" method="post">
			<div class="row">
				<div class="col-md-12 mb-2">
					<div class="row">
						<div class="col-md-2">
							<label for="title" class="col-form-label">제목</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" name="title" id="title" value="${book.TITLE }"/>
						</div>	
					</div>
				</div>
				<div class="col-md-12 mb-2">
					<div class="row">
						<div class="col-md-2">
							<label for="category" class="col-form-label">카테고리</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" name="category" id="category" value="${book.CATEGORY }"/>
						</div>	
					</div>
				</div>
				<div class="col-md-12 mb-2">
					<div class="row">
						<div class="col-md-2">
							<label for="price" class="col-form-label">가격</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" name="price" id="price" value="${book.PRICE }"/>
						</div>	
					</div>
				</div>
				<button type="submit" class="btn btn-info">수정</button>
				<a href="/book/list.do" class="btn btn-primary">목록</a>
			</div>
		</form>
	</div>
</body>
</html>