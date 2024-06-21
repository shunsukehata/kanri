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
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
    <link rel="stylesheet" href="css/emergencyContact.css">
    <title>緊急連絡先画面</title>
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
                <!-- c ifで出す出さないの判定をする -->
                <form method="post">
                    <div class="header-logout">
                        <button type="submit" class="header-button header-logout" onclick="location.href='login' ; return false;">ログアウト</button>
                    </div>
                 </form>
            </div>
         </div>
    </header>

    <main>
          <div class="form">

            <p class="text-contact">緊急連絡先</p>

            <div class="contact">
                <table><th class="c-font">・サイトに関する連絡先</th>
                    <tr>
                        <td class="free-dial">0120-123-4567</td>
                        <td>&nbsp;</td>
                            <td class="font-num">　　受付時間： 月曜～金曜　9:00～18:00
                                <br>　　定休日： 　土曜・日曜・祝日<br>
                                <br>　　Eメールでのお問い合わせ： 000000@japan.com</td>
                    </tr>
                </table>
            </div>

            <div class="contact">
                <table><th class="c-font">・法人に関する連絡先</th>
                    <tr>
                        <td class="free-dial">0120-123-4567</td>
                        <td>&nbsp;</td>
                            <td class="font-num">　　受付時間： 月曜～金曜　9:00～18:00
                                <br>　　定休日： 　土曜・日曜・祝日<br>
                                <br>　　Eメールでのお問い合わせ： 000000@japan.com</td>
                    </tr>
                </table>
            </div>

            <div class="contact">
                <table><th class="c-font">・その他の連絡先</th>
                    <tr>
                        <td class="free-dial">0120-123-4567</td>
                        <td>&nbsp;</td>
                            <td class="font-num">　　受付時間： 月曜～金曜　9:00～18:00
                                <br>　　定休日： 　土曜・日曜・祝日<br>
                                <br>　　Eメールでのお問い合わせ： 000000@japan.com</td>
                    </tr>
                </table>
            </div>

        </div>

        <div>
            <a href="home" class="backbtn">戻る</a>
          </div>

    </main>

    <footer>
        <p class="sample">COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
    </footer>

</body>

</html>