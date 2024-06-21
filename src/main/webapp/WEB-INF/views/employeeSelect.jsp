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
    <link rel="stylesheet" href="css/employeeSelect.css">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
    <title>社員情報検索画面</title>
</head>

<body>

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
    <form:form action="employeeSelectResult" modelAttribute="employeeSelect" method="post" >
      <fieldset class="select-form">
		<p class="select-text">検索したい社員情報を入力してください</p>
        <c:if test="${not empty errMsg}">
          <p class="p-err">${fn:escapeXml(errMsg)}</p>
 		</c:if>
        <div class="texta">
          <label>社員ID</label><br>
          <form:input path="empId" class="input-box"/>
        </div><br>

        <div class="texta">
          <label>名前</label><br>
          <form:input path="empName" class="input-box"/>
        </div><br>

        <div class="texta">
          <label>カナ</label><br>
          <form:input path="empKana" class="input-box"/>
        </div><br>

        <div class="texta">
          <label>TEL</label><br>
          <form:input path="tel" class="input-box"/>
        </div><br>

        <div class="text">
          <form:button class="btn">検索</form:button>
        </div>
	  </fieldset>

    </form:form>
  </main>

  <footer>
    <p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
  </footer>
</body>

</html>
