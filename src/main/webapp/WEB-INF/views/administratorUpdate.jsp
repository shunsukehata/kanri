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
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/administratorUpdate.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c"
	rel="stylesheet">
<title>変更画面</title>
</head>
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

	<form:form action="administratorUpdateResult" method="post"
		modelAttribute="administratorUpdateForm">
		<fieldset class="select-form">

			<p>変更したい情報を入力してください</p>
			<c:if test="${not empty errMsg}">
				<p class="p-err">${fn:escapeXml(errMsg)}</p>
			</c:if>

				<div class="Role">
					<label for="Role">役職</label>
				</div>
				<form:errors path="positionId" class="error" />
				<br> <span class="custom-dropdown big">
				<form:select path="positionId">
          		  <form:options items="${positionList}"
            		itemLabel="positionName" itemValue="positionId" />
        		  </form:select>
				</span>

			<div class="texta">
				<label for="name">名前</label>
				<form:errors path="empName" class="p-err1" />
				<br>
				<form:input path="empName" id="name" class="input-box"
					value="${fn:escapeXml(employee.empName)}" />
			</div>
			<div class="texta">
				<label for="kana">カナ</label>
				<form:errors path="empKana" class="p-err2" />
				<br>
				<form:input path="empKana" id="kana" class="input-box"
					value="${fn:escapeXml(employee.empKana)}" />
			</div>

			<div class="texta">
				<label for="login-id">ログインID</label>
				<form:errors path="loginId" class="p-err3" />
				<br>
				<form:input path="loginId" id="login-id" class="input-box"
					value="${fn:escapeXml(employee.loginId)}" />
			</div>
			<div class="texta">
				<label class="required" for="pass">PASSWORD</label>
				<form:errors path="pass" class="p-err4" />
				<br>
				<form:password path="pass" id="pass" class="input-box"
					value="${fn:escapeXml(employee.pass)}" />
			</div>

			<div class="texta">
				<label class="required" for="passa">PASSWORD再入力</label>
				<form:errors path="rePass" class="p-err5" />
				<br>
				<form:password path="rePass" id="passa" class="input-box" />
			</div>
			<div class="texta">
				<label for="tell">電話番号</label>
				<form:errors path="tel" class="p-err6" />
				<br>
				<form:input path="tel" id="tell" class="input-box"
					value="${fn:escapeXml(employee.tel)}" />
			</div>

			<div class="texta">
				<label for="mail-address">メールアドレス</label>
				<form:errors path="mail" class="p-err7" />
				<br>
				<form:input path="mail" id="mail-address" class="input-box"
					value="${fn:escapeXml(employee.mail)}" />
			</div>

			<div class="texta">
				<label for="postal-code">郵便番号(7桁)</label>
				<form:errors path="postCode" class="p-err8" />
				<br>
				<form:input path="postCode" size="10" maxlength="8"
					onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');"
					class="input-box" value="${fn:escapeXml(employee.postCode)}" />
			</div>

			<div class="texta">
				<label for="postal-code">都道府県+以降の住所</label>
				<form:errors path="address" class="p-err9" />
				<br>
				<form:input path="address" size="60" class="input-box"
					value="${fn:escapeXml(employee.address)}" />
			</div>

			<div class="text">
				<button type="submit" class="btn">変更</button>
			</div>
		</fieldset>
	</form:form>
</main>

<footer>
	<p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
</footer>

<div class="bg_pattern Paper_v2"></div>
<div class="section"></div>

</body>

</html>
