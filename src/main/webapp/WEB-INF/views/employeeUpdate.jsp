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
    <link rel="stylesheet" href="css/employeeUpdate.css">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">

    <title>更新画面</title>
</head>
  <header>
    <div class="header-inner">
      <div class="menu">かんりちゃん</div>
      <div class="header-box">

        <table>
          <tr>
            <td><a href="home" class="btn-main">ホーム</a></td>
            <td><a href="todo" class="btn-todo">ToDo</a></td>
          </tr>
          <tr>
            <td><a href="employeeSelect" class="btn-select">社員検索</a></td>
            <td><a href="emergencyContact" class="btn-emergencyContact">緊急連絡先</a></td>
          </tr>
        </table>
      </div>
      <div class="clearfix">
        <c:if test="${adminUser eq true}">
          <a href="menu" class="role">管理者メニュー</a>
        </c:if>
        <form method="post">
          <div class="header-logout">
            <button type="submit" class="header-button header-logout" onclick="location.href='login' ; return false;">ログアウト</button>
          </div>
        </form>
      </div>
    </div>
  </header>

  <main>
	<form:form action="employeeUpdateResult" method="post" modelAttribute="EmployeeUpdateForm">
      <fieldset class="select-form">
		<p class="update-text">変更したい項目を入力してください</p>
		<c:if test="${not empty errMsg}">
		  <p class="p-err">${fn:escapeXml(errMsg)}</p>
		</c:if>

    	<div class="texta">
		  <label for="name">名前</label>
		  <form:errors path="empName" class="p-err1" /><br>
		  <form:input path="empName" id="name" class="input-box" value="${fn:escapeXml(loginUser.empName)}" />
		</div>

		<div class="texta">
		  <label for="kana">カナ</label>
		  <form:errors path="empKana" class="p-err2" /><br>
		  <form:input path="empKana" id="kana" class="input-box" value="${fn:escapeXml(loginUser.empKana)}" />
		</div>

		<div class="texta">
		  <label for="login-id">ログインID</label>
		  <form:errors path="loginId" class="p-err3" /><br>
		  <form:input path="loginId" id="login-id" class="input-box" value="${fn:escapeXml(loginUser.loginId)}" />
		</div>

		<div class="texta">
		  <label class="required" for="pass">PASSWORD</label>
		  <form:errors path="pass" class="p-err4" /><br>
		  <form:password path="pass" id="pass" class="input-box" value="${fn:escapeXml(loginUser.pass)}" />
		</div>

		<div class="texta">
		  <label class="required" for="passa">PASSWORD再入力</label>
		  <form:errors path="rePass" class="p-err5" /><br>
		  <form:password path="rePass" id="passa"  class="input-box" />
		</div>

		<div class="texta">
		  <label for="tell">電話番号</label>
		  <form:errors path="tel" class="p-err6" /><br>
		  <form:input path="tel" id="tell" class="input-box" value="${fn:escapeXml(loginUser.tel)}" />
		</div>

		<div class="texta">
		  <label for="mail-address">メールアドレス</label>
		  <form:errors path="mail" class="p-err7" /><br>
		  <form:input path="mail" id="mail-address" class="input-box" value="${fn:escapeXml(loginUser.mail)}" />
		</div>

		<div class="texta">
		  <label for="postal-code">郵便番号(7桁)</label>
		  <form:errors path="postCode" class="p-err8" /><br>
		  <form:input path="postCode" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');" class="input-box" value="${fn:escapeXml(loginUser.postCode)}" />
		</div>

		<div class="texta">
		  <label for="postal-code">都道府県+以降の住所</label>
		  <form:errors path="address" class="p-err9" /><br>
		  <form:input path="address" size="60" class="input-box" value="${fn:escapeXml(loginUser.address)}" />
		</div>

        <div class="text">
          <form:button type="submit" class="btn">更新</form:button>
        </div>

      </fieldset>
    </form:form>
  </main>

  <footer>
    <p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
  </footer>
</body>

</html>
