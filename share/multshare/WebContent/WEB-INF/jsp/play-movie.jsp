<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<!-- <meta name="viewport" content="width=device-width; initial-scale=1.0"> -->
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<title>play-movie</title>
</head>

<body bgcolor="white">
<div >
<div style="font-size:18px;">欢迎观看</div>
</div>

<div>
   <div>
        <video id="myVideo" width="345" height="200" poster="${serviceaddress}/${playMovie.picpath }"  controls preload="auto" >
			<source id="source" src="${serviceaddress}/${playMovie.repath }" type="video/mp4"></source> 
		</video>
<div style="font-size:15px">${showname }</div>
<div style="font-size:10px;color:blue;" id="showTime"></div>
	</div>
	
<div style="font-size:15px;margin-top:40px">简介：</div>
<hr>
<div style="font-size:10px">${playMovie.searchkey }</div>
<hr>
<div style="font-size:10px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${playMovie.info }</div>

</div>
        


<script type="text/javascript">
var myVideo = document.getElementById("myVideo");
var showTime = document.getElementById("showTime");

var vLength = 0;//总长
var vCurrentTime = 0;//当前时间
myVideo.onloadedmetadata = function () {//加载完成
	vLength = myVideo.duration;//总长
	showTime.innerHTML = "时长：";
}
myVideo.ontimeupdate = function () {//播放时间改变
	vLength = myVideo.duration;//总长
	vCurrentTime = myVideo.currentTime;//当前时间
	showTime.innerHTML = "时长："+parseInt(vCurrentTime/60)+":"+parseInt(vCurrentTime%60)+
	"/"+parseInt(vLength/60)+":"+parseInt(vLength%60);
}



	
</script> 

</body>
</html>
