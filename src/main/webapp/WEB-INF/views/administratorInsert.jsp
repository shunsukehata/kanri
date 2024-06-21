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
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c"
	rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/administratorInsert.css">
<title>登録画面</title>
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

		<form:form action="administratorInsertResult" method="post"
			modelAttribute="AdministratorInsertForm">
			<fieldset class="select-form">

				<p>追加する社員の情報を入力してください</p>
				<c:if test="${not empty errMsg}">
					<p class="error">${fn:escapeXml(errMsg)}</p>
				</c:if>

				<div class="Role">
					<label for="Role">役職</label>
				</div>
				<form:errors path="positionId" class="p-err" />
				<br>
				<span class="custom-dropdown big">
				<form:select path="positionId">
          		  <form:options items="${positionList}"
            		itemLabel="positionName" itemValue="positionId" />
        		  </form:select>
				</span>



				<div class="texta">
					<label for="name">名前</label>
					<form:errors path="empName" class="p-err" />
					<br>
					<form:input id="name" class="input-box" path="empName" />
				</div>
				<div class="texta">
					<label for="kana">カナ</label>
					<form:errors path="empKana" class="p-err1" />
					<br>
					<form:input id="kana" class="input-box" path="empKana" />
				</div>

				<div class="Birthday">
					<label for="Birthday">生年月日(8桁)</label>
					<c:if test="${not empty birthErrMsg}">
					<p class="p-err13">${fn:escapeXml(birthErrMsg)}</p>
					</c:if>
					<form:errors path="birth" class="p-err2" />
				</div>

				<br>
				<div class="texta">
					<label class="birthday"> <form:input class="input-box1"
							path="birth" placeholder="YYYYMMDD" oninput="value = value.replace(/[０-９]/g,s => String.fromCharCode(s.charCodeAt(0) - 65248)).replace(/\D/g,'');" />
					</label>
				</div>

				<div class="Gender">
					<label for="Gender">性別</label>
				</div>
				<form:errors path="genderId" class="p-err3" />
				<br> <span class="custom-dropdown big">
				 <form:select path="genderId">
          		  <form:options items="${genderList}"
            		itemLabel="genderName" itemValue="genderId" />
        		  </form:select>
				</span>


				<div class="texta">
					<label for="login-id">ログインID</label>
					<form:errors path="loginId" class="p-err4" />
					<br>
					<form:input id="login-id" class="input-box" path="loginId" />
				</div>
				<div class="texta">
					<label class="required" for="pass">PASSWORD</label>
					<form:errors path="pass" class="p-err5" />
					<br>
					<form:password id="pass" class="input-box" path="pass" />
				</div>

				<div class="texta">
					<label class="required" for="passa">PASSWORD再入力</label>
					<form:errors path="rePass" class="p-err6" />
					<br>
					<form:password id="passa" class="input-box" path="rePass" />
				</div>
				<div class="texta">
					<label for="tell">電話番号</label>
					<form:errors path="tel" class="p-err7" />
					<br>
					<form:input id="tell" class="input-box" path="tel" />
				</div>

				<div class="texta">
					<label for="mail-address">メールアドレス</label>
					<form:errors path="mail" class="p-err8" />
					<br>
					<form:input id="mail-address" class="input-box" path="mail" />
				</div>

				<div class="texta">
					<label for="postal-code">郵便番号(7桁)</label>
					<form:errors path="postCode" class="p-err9" />
					<br>
					<form:input size="10" maxlength="8"
						onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');"
						class="input-box" path="postCode" />
				</div>

				<div class="texta">
					<label for="postal-code">都道府県+以降の住所</label>
					<form:errors path="address" class="p-err10" />
					<br>
					<form:input size="60" class="input-box" path="address" />
				</div>

				<div class="text">
					<form:button class="btn">登録</form:button>
				</div>
			</fieldset>
		</form:form>
	</main>

	<footer>
		<p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
	</footer>
	<div class="bg_pattern Paper_v2"></div>
	<div class="section"></div>


	<script type="text/javascript" src="../js/administratorInsert.JS"></script>
</body>

</html>
