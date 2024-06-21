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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="css/administratorDelete.css">
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
            <form:form action="administratorDeleteConfirm" method="post" modelAttribute="AdministratorDeleteForm">
                <fieldset class="select-form">
                    <p>削除したい社員IDを入力してください</p>
                     <c:if test="${not empty errMsg}">
                <p class="p-err1">${fn:escapeXml(errMsg)}</p><br>
 			       </c:if>
                    <!-- <p class="p-err">※IDまたはPASSが違います</p> -->
                    <div class="texta">
                        <label>社員ID</label><br>
                        <form:errors path="empId" class="p-err" />
                        <form:input path="empId" name="userID" class="input-box"/>
                    </div><br>
                    <div class="text">
                        <form:button type="submit" class="btn">次へ</form:button>
                    </div>
                </fieldset>
             </form:form>
        </div>
    </main>
    <footer>
        <p class="sample">COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
    </footer>
    <div class="bg_pattern Paper_v2"></div>
    <div class="section"></div>

</body>

</html>
