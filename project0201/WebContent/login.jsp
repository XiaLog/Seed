<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta content="always" name="referrer">
<title>无标题文档</title>
<link href="css/login.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script>
$(function()
{
	windowSize();
	scrollBanner();
})
$(window).resize(function()
{
	windowSize();
});
function windowSize()
{
	if($(window).height() < 640)
	{
		$('#footer').css('position','static');
	}
	else
	{
		$('#footer').css('position','fixed');
	}
}

//轮播
var iNow = 1;
var scrollTimer = null;
function scrollBanner()
{
	clearInterval(scrollTimer);
	scrollTimer = setInterval(auto,4000);
	function auto()
	{
		if(iNow == $('.banner li').length)
		{
			iNow = 0;
		}
		scrollRun(iNow);
		iNow ++;
	}
	
	function scrollRun(index)
	{
		$('.banner li').fadeOut(1000);
		$('.banner li').eq(index).fadeIn(1000);
	}
}
</script>

<script>
   $(function(){
	   $("#log").click(function(){
		   $("#log_form").submit();
	   });
   });
</script>

<script>
    function reloadCode(){
        var time = new Date().getTime();
        document.getElementById('imagecode').src = '<%=request.getContextPath()%>/servlet/ImageServlet?d=' + time;
    }
</script>




</head>
<body>
<div id="header">
	<a class="fl" href="#"><img width="226" height="50" src="images/logo.jpg" /></a>
</div>

<form action="login.do" id="log_form" method="post">
<div id="wrap">
	<div class="fl">
    	<ul class="banner">
        	<li class="active"><img src="images/b1.png" /></li>
        	<li><img src="images/b2.png" /></li>
        	<li><img src="images/b3.png" /></li>
        </ul>
    </div>
    <div class="login fr">
    	<div class="login_1"><img src="images/login_box_logo.png" />种子项目管理系统</div>
        <div class="login_2">
        	<div class="login_3">
                <input class="username" type="text" placeholder="用户名" name="empname"/>
                <input type="password" placeholder="密码" name="password"/>
                <input class="yzm fl" type="text" placeholder="验证码" name="checkCode"/>
                <div class="yzm_img fl"><img alt="验证码" id="imagecode" src="<%= request.getContextPath()%>/servlet/ImageServlet"/></div>
                <a class="hyz fl" href="javascript:reloadCode();">换一张</a>
                <div class="clear"></div>
                <div class="login_4">
                    <label>
                        <input type="checkbox" />
                        <span>记住账户</span>
                    </label>
                    <a href="#" class="fr">忘记密码</a>
                </div>
            </div>
            <!-- <a href="html/index.html" class="login_5">登&nbsp;&nbsp;&nbsp;&nbsp;录</a> -->
        </div>
        <a href="javascript:return void(0);" class="login_7" id="log">登　　录</a>
    </div>
</div>
</form>
<div id="footer">
	<div class="footer_2">版权所有：欧辰科技有限公司</div>
</div>
</body>
</html>
