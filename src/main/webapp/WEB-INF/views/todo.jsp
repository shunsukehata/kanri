<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>ToDoリスト</title>
    <meta name="description" content="TO DO アプリです">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/todo.css">
    <script src="js/app.min.js?171029002" defer></script>
    <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">

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
        <!-- /.header -->
    <div class="container-fluid">

        <div class="row mainContainer">
            <div class="col-md-8 col-xl-9 taskContainer">
                <div id="stage"></div>
                <div class="taskFormContainer bg-dark">
                    <form name="taskForm" id="js-taskForm">
                        <div class="container-fluid py-3">
                            <div class="row">
                                <div class="col-xl-5 mb-2 mb-xl-0">
                                    <div class="mb-1 small text-white">内容<span class="badge badge-danger ml-2">※必須</span></div>
                                    <div>
                                        <input type="text" name="content" class="form-control" required placeholder="タスクを入力してください">
                                    </div>
                                </div>
                                <div class="col-xl row">
                                    <div class="col-sm-auto col-md-auto col-xl">
                                        <div class="mb-1 small text-white">優先度<span class="badge badge-danger ml-2">※必須</span></div>
                                        <div class="text-white">
                                            <label class="custom-control custom-radio">
                                            <input type="radio" name="priority" value="3" class="custom-control-input" required>
                                            <span class="custom-control-indicator"></span>
                                            <span class="custom-control-description">高</span>
                                        </label>
                                            <label class="custom-control custom-radio">
                                            <input type="radio" name="priority" value="2" class="custom-control-input" checked>
                                            <span class="custom-control-indicator"></span>
                                            <span class="custom-control-description">中</span>
                                        </label>
                                            <label class="custom-control custom-radio">
                                            <input type="radio" name="priority" value="1" class="custom-control-input">
                                            <span class="custom-control-indicator"></span>
                                            <span class="custom-control-description">低</span>
                                        </label>
                                        </div>
                                    </div>
                                    <div class="col-auto col-sm-auto col-xl mb-3 mb-sm-0">
                                        <div class="mb-1 small text-white">期限</div>
                                        <input type="date" name="limit" class="form-control">
                                    </div>
                                    <div class="col-sm-auto col-lg col-xl align-self-center">
                                        <input type="submit" value="追加" class="btn btn-primary mb-1">
                                        <input type="reset" value="クリア" class="btn btn-secondary mb-1">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.container -->
                    </form>
                    <!-- /.taskForm -->
                </div>
            </div>

            <div class="col-md-4 col-xl-3">
                <div class="sticky-top">
                    <div class="statusBox mb-4 mb-md-5" id="js-statusBox">
                        <table class="table table-bordered">
                            <tr>
                                <th>現在のタスク総数</th>
                                <td><span class="totalCount">0</span> 個</td>
                            </tr>
                            <tr>
                                <th>残タスク数</th>
                                <td><span class="leftCount">0</span> 個</td>
                            </tr>
                            <tr>
                                <th>完了済みタスク数</th>
                                <td><span class="completeCount">0</span> 個
                                    <div class="taskDeleteBtn js-none" id="js-taskDeleteBtn">

                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>完遂率</th>
                                <td><span class="completionRate">0</span> ％</td>
                            </tr>
                        </table>
                    </div>
                    <!-- /.statusBox -->
                    <div class="sortArea mb-3">
                        <h2 class="h6 font-weight-bold">タスクの並び替え</h2>
                        <div class="btn-group w-100 sortBtns" id="js-sort">
                            <button class="btn btn-outline-secondary w-50 js-sort-priority">優先度順</button>
                            <button class="btn btn-outline-secondary w-50 js-sort-limit">期限順</button>
                        </div>
                    </div>
                    <!-- /.sortArea -->
                    <div class="mb-4 mb-md-5">
                        <button class="btn btn-outline-danger w-100" id="js-removeAllItem">全タスク削除</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.mainContainer -->

        <div class="modal" id="js-modal">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">編集</h5>
                        <button type="button" class="close js-modal-close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    </div>
                    <form name="taskEditForm" id="js-taskEdit">
                        <div class="modal-body">
                            <ul class="list-unstyled">
                                <li>内容 <input type="text" name="content" class="form-control" required></li>
                                <li>優先度
                                    <div>
                                        <label class="custom-control custom-radio">
                                        <input type="radio" name="priority" value="3" class="custom-control-input" required>
                                        <span class="custom-control-indicator"></span>
                                        <span class="custom-control-description">高</span>
                                    </label>
                                        <label class="custom-control custom-radio">
                                        <input type="radio" name="priority" value="2" class="custom-control-input" checked>
                                        <span class="custom-control-indicator"></span>
                                        <span class="custom-control-description">中</span>
                                    </label>
                                        <label class="custom-control custom-radio">
                                        <input type="radio" name="priority" value="1" class="custom-control-input">
                                        <span class="custom-control-indicator"></span>
                                        <span class="custom-control-description">低</span>
                                    </label>
                                    </div>
                                </li>
                                <li>期限 <input type="date" name="limit" class="form-control"></li>
                            </ul>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-primary" value="完了">
                            <input type="reset" class="btn btn-secondary" value="クリア">
                        </div>
                    </form>
                    <!-- /.taskForm -->
                </div>
            </div>
            <div class="modal-bg"></div>
        </div>
    </div>
    <!-- /.container-fluid -->

    <footer>
        <p>COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
    </footer>
</body>

</html>