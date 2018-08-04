<html>
<head>
    <meta charset="utf-8">
    <title>Share With Swiper</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="jquery/swiper/css/swiper.min.css">
    <script src="jquery/jquery-1.7.2.min.js"></script>
 	<!-- Swiper JS -->
    <script src="jquery/swiper/js/swiper.min.js"></script>
    
    <!-- Swiper styles -->
    <style>
    html, body {
        position: relative;
        height: 100%;
    }
    body {
        background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;
    }
    .swiper-container {
        width: 100%;
        height: 100%;
        background: #000;
    }
    .swiper-slide {
        font-size: 18px;
        color:#fff;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        padding: 40px 60px;
    }
    .parallax-bg {
        position: absolute;
        left: 0;
        top: 0;
        width: 130%;
        height: 100%;
        -webkit-background-size: cover;
        background-size: cover;
        background-position: center;
    }
    .swiper-slide .title {
        font-size: 41px;
        font-weight: 300;
    }
    .swiper-slide .subtitle {
        font-size: 21px;
    }
    .swiper-slide .text {
        font-size: 14px;
        max-width: 400px;
        line-height: 1.3;
    }
    </style>
</head>
<body>
    <!-- Swiper -->
    <div class="swiper-container">
        <div class="parallax-bg" style="background-image:url(${serviceaddress}/background/bg-1.png)" data-swiper-parallax="-23%"></div>
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <img id="play-movie" alt="电影播放" title="电影播放" src="${serviceaddress}/background/movie-1.png" 
                width="65%" height="35%" style="margin-top:30%;margin-left:22%">
                <div class="subtitle" style="margin-top:30%;margin-left:35%">电影播放</div>
                <div style="height:90px"></div>
        	<font color="white" size="1px"style="margin-top:50%;margin-left:8%">guagua-corporation-liqd&nbsp;copyright © 2017-2077</font>
            </div>
            <div class="swiper-slide">
                <img id="share" alt="文件共享" title="文件共享" src="${serviceaddress}/background/share-1.png" 
                width="65%" height="35%" style="margin-top:30%;margin-left:22%">
                <div class="subtitle" style="margin-top:30%;margin-left:35%">文件共享</div>
            </div>
            <div class="swiper-slide">
                <img id="chat" alt="聊天大厅" title="聊天大厅" src="${serviceaddress}/background/chat-1.png" 
                width="65%" height="35%" style="margin-top:30%;margin-left:22%">
                <div class="subtitle" style="margin-top:30%;margin-left:35%">聊天大厅</div>
            </div>
            <div class="swiper-slide">
                <img id="setting" alt="系统设置" title="系统设置" src="${serviceaddress}/background/setting-1.png" width="65%" height="35%" style="margin-top:30%;margin-left:22%">
                <div class="subtitle" style="margin-top:30%;margin-left:35%">系统设置</div>
            </div>
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination swiper-pagination-white"></div>
        <!-- Add Navigation -->
        <div class="swiper-button-prev swiper-button-white"></div>
        <div class="swiper-button-next swiper-button-white"></div>
    </div>

    <!-- Initialize Swiper -->
    <script>
    var swiper = new Swiper('.swiper-container', {
    	loop: true,
        pagination: '.swiper-pagination',
        paginationClickable: true,
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        parallax: true,
        speed: 600,
    });
    
    $(function(){
	    $("#play-movie,#share,#chat,#setting").click(function(){
	    	if("play-movie"==$(this).attr("id")){
	    		window.location.href="${serviceaddress}:8080/ms/playMovie/list.do";
	    	}
	    	else if("share"==$(this).attr("id")){
	    		window.location.href="${serviceaddress}:8080/ms/share/list.do";
	    	}
	    });
    });
    </script>
</body>
</html>