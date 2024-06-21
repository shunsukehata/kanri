<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/administratorDeleteConfirm.css">
<title>管理者削除メニュー</title>
</head>

<body>
	<header>
		<div class="header-inner">
			<div class="menu">かんりちゃん</div>
			<div class="wrap">
				<a href="home" class="button-home">一般メニュー</a> <a
					href="menu" class="button-menu">ホーム</a>
			</div>
			<form method="post">
				<div class="header-logout">
					<button type="submit" class="header-button"
						onclick="location.href='login' ; return false;">ログアウト</button>
				</div>
			</form>
		</div>
	</header>
	<main>
		<div class="form">

			<form:form action="administratorDeleteResult" method="post"
				modelAttribute="AdministratorDeleteForm">
				<table class="select-teble">
					<caption>削除確認</caption>
					<form:hidden path="empId" value="${fn:escapeXml(employee.empId)}" />
					<tbody>
						<tr>
							<th>役職</th>
							<td>${fn:escapeXml(deleteEmploee.positionName)}</td>
						</tr>
						<tr>
							<th>名前</th>
							<td>${fn:escapeXml(deleteEmploee.empName)}</td>
						</tr>
						<tr>
							<th>カナ</th>
							<td>${fn:escapeXml(deleteEmploee.empKana)}</td>
						</tr>
						<tr>
							<th>生年月日</th>
							<td>${fn:escapeXml(deleteEmploee.birth)}</td>
						</tr>
						<tr>
							<th>性別</th>
							<td>${fn:escapeXml(deleteEmploee.genderName)}</td>
						</tr>
						<tr>
							<th>電話番号</th>
							<td>${fn:escapeXml(deleteEmploee.tel)}</td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td>${fn:escapeXml(deleteEmploee.mail)}</td>
						</tr>
						<tr>
							<th>郵便番号</th>
							<td>${fn:escapeXml(deleteEmploee.postCode)}</td>
						</tr>
						<tr>
							<th>住所</th>
							<td>${fn:escapeXml(deleteEmploee.address)}</td>
						</tr>

					</tbody>
				</table>
				<div class="text">
					<button type="submit" class="btn"
						onclick="return confirm('本当に削除して良いですか？')">削除</button>
				</div>
			</form:form>

		</div>

	</main>
	<footer>
		<p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
	</footer>
	<div class="bg_pattern Paper_v2"></div>
	<div class="section"></div>
</body>

</html>
