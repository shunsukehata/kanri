<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/employeeSelectResult.css">
<link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css"
	rel="stylesheet">
<title>社員情報検索結果画面</title>
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
	    <div class="select-form">
		  <c:forEach items="${empInfo}" var="employee">
		    <table class="select-teble">
			<!-- align="center"  -->
			  <caption>検索結果を表示します</caption>
			  <thead>

			  <tr>
				<th colspan="2"><img src="../img/baseline_account_circle_black_24dp.png" class="face"></th>
			  </tr>

			  <tr>
				<th>役職</th>
				<td>${fn:escapeXml(employee.positionName)}</td>
			  </tr>

			  <tr>
			    <th>名前</th>
				<td>${fn:escapeXml(employee.empName)}</td>
			  </tr>

			  <tr>
				<th>カナ</th>
				<td>${fn:escapeXml(employee.empKana)}</td>
			  </tr>

			  <tr>
				<th>生年月日</th>
				<td>${fn:escapeXml(employee.birth)}</td>
			  </tr>

			  <tr>
				<th>性別</th>
				<td>${fn:escapeXml(employee.genderName)}</td>
			  </tr>

			  <tr>
				<th>ログインID</th>
				<td>${fn:escapeXml(employee.loginId)}</td>
			  </tr>

			  <tr>
				<th>TEL</th>
				<td>${fn:escapeXml(employee.tel)}</td>
			  </tr>

			  <tr>
				<th>メールアドレス</th>
				<td>${fn:escapeXml(employee.mail)}</td>
			  </tr>

			  <tr>
				<th>郵便番号</th>
				<td>${fn:escapeXml(employee.postCode)}</td>
			  </tr>

			  <tr>
				<th>住所</th>
				<td>${fn:escapeXml(employee.address)}</td>
			  </tr>

			</thead>
		  </table>
		</c:forEach>
		<div>
		  <a href="employeeSelect" class="backbtn">戻る</a>
		</div>

	  </div>
	</main>


  <footer>
	<p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
  </footer>
</body>

</html>