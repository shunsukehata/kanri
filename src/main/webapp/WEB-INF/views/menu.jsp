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
    <link rel="stylesheet" href="css/menu.css">
    <title>管理者メニュー画面</title>
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
    <div class="textarea">
      <a href="administratorInsert" class="employee-insert">社員情報登録</a>
      <a href="administratorInsertSelect" class="employee-update">社員情報変更</a>
      <a href="administratorDelete" class="employee-delete">社員情報削除</a>
    </div>

    <div class="form">
      <p class ="text2">${fn:escapeXml(loginUser.empName)}さん、こんにちは!</p>
      <!--デジタル時計の表示位置-->
            <p id="Clock1" style="display: inline"></p>
            <script type="text/javascript">
                setInterval('showClock1()', 1000);
                function showClock1() {
                    var DWs = new Array('Sun.', 'Mon.', 'Tue.', 'Wed.', 'Thu.', 'Fri.', 'Sat.');
                    var Now = new Date();
                    var YY = Now.getYear();
                    if (YY < 2000) { YY += 1900; }
                    var MM = set0(Now.getMonth() + 1);
                    var DD = set0(Now.getDate());
                    var DW = DWs[Now.getDay()];
                    var hh = set0(Now.getHours());
                    var mm = set0(Now.getMinutes());
                    var ss = set0(Now.getSeconds());
                    var RTime1 = ' ' + YY + '.' + MM + '.' + DD + ' ' + DW + ' ' + hh + ':' + mm + ':' + ss + ' ';
                    document.getElementById("Clock1").innerHTML = RTime1;
                }
                function set0(num) {
                    var ret;
                    if (num < 10) { ret = "0" + num; }
                    else { ret = num; }
                    return ret;
                }
            </script>

       <!-- weather widget start -->
       <div id="m-booked-custom-widget-2443">
         <div class="weather-customize" style="width:350px;">
           <div class="booked-weather-custom-160 color-009fde" style="width:350px;" id="width5">
             <div class="booked-weather-custom-160-date">天気, 21 6月</div>
             <div class="booked-weather-custom-160-main"> <a target="_blank" href="https://booked.jp/weather/tokyo-18247" class="booked-weather-custom-160-city"> 東京都の天気 </a>
               <div class="booked-weather-custom-160-degree booked-weather-custom-C wmd18"><span><span class="plus">+</span>25</span>
             </div>
             <div class="booked-weather-custom-details">
               <p>
                 <span>最高: <strong><span class="plus">+</span>26<sup>°</sup></strong></span>
                 <span> 最低: <strong><span class="plus">+</span>21<sup>°</sup></strong></span>
               </p>
               <p>湿度: <strong>59%</strong></p>
               <p>風速: <strong>S - 34 KPH</strong></p>
             </div>
           </div>
         </div>
       </div>
     </div>

     <script type="text/javascript">
       var css_file = document.createElement("link");
       var widgetUrl = location.href;
       css_file.setAttribute("rel", "stylesheet");
       css_file.setAttribute("type", "text/css");
       css_file.setAttribute("href", 'https://s.bookcdn.com/css/weather.css?v=0.0.1');
       document.getElementsByTagName("head")[0].appendChild(css_file);

       function setWidgetData_2443(data) {
         if (typeof(data) != 'undefined' && data.results.length > 0) {
            for (var i = 0; i < data.results.length; ++i) {
              var objMainBlock = document.getElementById('m-booked-custom-widget-2443');
                if (objMainBlock !== null) {
                  var copyBlock = document.getElementById('m-bookew-weather-copy-' + data.results[i].widget_type);
                  objMainBlock.innerHTML = data.results[i].html_code;
                  if (copyBlock !== null) objMainBlock.appendChild(copyBlock);
                }
            }
            } else {
              alert('data=undefined||data.results is empty');
            }
         }
         var widgetSrc = "https://widgets.booked.net/weather/info?action=get_weather_info;ver=7;cityID=18247;type=2;scode=124;ltid=3457;domid=587;anc_id=73122;countday=undefined;cmetric=1;wlangID=16;color=009fde;wwidth=350;header_color=ffffff;text_color=333333;link_color=08488D;border_form=1;footer_color=ffffff;footer_text_color=333333;transparent=0;v=0.0.1";
         widgetSrc += ';ref=' + widgetUrl;
         widgetSrc += ';rand_id=2443';
         var weatherBookedScript = document.createElement("script");
         weatherBookedScript.setAttribute("type", "text/javascript");
         weatherBookedScript.src = widgetSrc;
         document.body.appendChild(weatherBookedScript)
       </script>
       <!-- weather widget end -->
     </div>
   </main>

   <footer>
     <p class="sample">COPYRIGHT © Bgroup,Inc. All rights reserved.</p>
   </footer>

   <div class="bg_pattern Paper_v2"></div>
   <div class="section"></div>
</body>

</html>
