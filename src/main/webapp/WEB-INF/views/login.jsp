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
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
    <title>ログイン画面</title>
</head>

<body>
    <header></header>

    <main>
      <div class="login-page">
          <div class="write">
            <h1 class="write-heading">
              <span class="write-heading-first">かんりちゃんへようこそ</span>
              <span class="write-heading-second">LOGIN FORM</span>
            </h1>
          </div>

          <div class="form">
          <c:if test="${not empty errMsg}">
              <p class="p-err">${fn:escapeXml(errMsg)}</p>
 			</c:if>

 			<form class="register-form">
              <input type="text" placeholder="社員ID" />
              <!--<form:errors path="empId" class="p-err"/>-->

              <input type="text" placeholder="メールアドレス" />
              <!--<form:errors path="mail" class="p-err"/>-->

              <div class="box">
                <a href="contactFormResult" class="btn-contct" >パスワードの再設定リクエストを送信</a>
              </div>
              <p class="message">ログインをされますか? <a href="#">ログイン</a></p>
			</form>

            <form:form action="login" method="post" modelAttribute="login" class="login-form">
              <form:input path="loginId" placeholder="ログインID" />
              <form:errors path="loginId" class="p-err"/>

              <div class="box-pass">
                <form:password class="js-password" path="pass" id="pass-login" name="pass-login" maxlength="10" placeholder="パスワード"/>
                <form:errors path="pass" class="p-err"/>
                <input class="js-password-toggle button__input" id="password--eye" type="checkbox" name="password01">
                <label class="js-password-label button__label" for="password--eye"><i class="fas fa-eye"></i></label>
              </div>

              <form:button>ログイン</form:button>
              <p class="message">パスワードをお忘れですか? <a href="#">お問い合わせ</a></p>
            </form:form>
          </div>
        </div>
      </main>

      <footer></footer>
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
      <script type="text/javascript" src="../js/login.js"></script>
    </body>
</html>
