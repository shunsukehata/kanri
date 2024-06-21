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
    <title>お問い合わせフォーム画面</title>
    <link rel="stylesheet" href="css/cotactFormResult.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
</head>

<body>

    <header>
        <p class="sample">かんりちゃん</p>
    </header>

    <main>
      <div class="form">
        <h2>パスワードの再設定リクエストを受け付けました。</h2>
		<div>入力いただいたメールアドレスの確認後、パスワード再設定の手順をお送りします。</div>

        <ul>
          <div class="list">info@bgroup.comからパスワード再設定の案内が届きますので、<br> 30分以内にご確認いただき、パスワードの再設定を行ってください。</div>
          <div class="list">メールが届かない場合は、入力いただいたメールアドレスが<br> 登録いただいたアドレスとお間違いないか今一度ご確認ください。</div>
          <div class="list">またスパムフォルダや迷惑メールに届いている場合がございますので、こちらもご確認ください。</div>
          <div class="list">上記を試していただいてもメールが届かない場合、お手数ですがお問い合わせからご連絡ください。</div>
        </ul>
        <a href="login" class="btn-back">戻る</a>
      </div>
    </main>

    <footer>
        <p class="sample3">COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
    </footer>

</body>

</html>