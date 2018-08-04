<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">

<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>play-movie-list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="jquery/swiper/css/swiper.min.css">
    <link rel="stylesheet" href="jquery/pagination/pagination.css">
    <script src="jquery/jquery-1.7.2.min.js"></script>
    <script src="jquery/pagination/jquery.pagination.js"></script>
 	<!-- Swiper JS -->
    <script src="jquery/swiper/js/swiper.min.js"></script>

    <!-- Demo styles -->
    <style>
    html, body {
        position: relative;
        height: 100%;
    }
    body {
        background: #fff;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;
    }
    .swiper-container {
        width: 100%;
        height: 100%;
    }
    .swiper-slide {
        font-size: 18px;
        height: auto;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
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
    </style>
</head>
<body>
    <!-- Swiper -->
    <div style="vertical-align:middle">
        搜索&nbsp;<input type="text" id="searchInfo" maxlength="10" ><img src="http://192.168.173.1/background/search-1.png" 
	style="width:25px;height:23px;position: absolute;top:0px;left: 210px;z-index:2;" onclick="displayData(0);">
    </div>
        
    <div id="mainSwiper" class="swiper-container" ><!-- 水平滑动 -->
    	<div class="parallax-bg" style="background-image:url(http://192.168.173.1/background/bg-1.png)" data-swiper-parallax="-23%"></div>
        <div class="swiper-wrapper" >
            <div class="swiper-slide" id="commenDiv"><!-- 需要加载完成后动态设定高度 -->
            	 <div id="ziyuanSwiper-1" class="swiper-container"><!-- 垂直滑动 -->
				        <div class="swiper-wrapper">
				            <div class="swiper-slide">
               					<div style="color:white;font-size:17px;weight:350px;">视频资源
               						<form action="">
               							<input type="file" value="shangchuan"/>上传
               						</form>
               					</div>
               					<table id="movieInfoTBody" style="width:350px;" >
                	
                				</table>
                				<div style="margin-top:20px;"></div><!-- 占位行 -->
        							<%@include file="common/pageFoot.jsp"%>
                				<div style="margin-top:20px;"></div><!-- 占位行除电影展示外共238px -->
            				</div>
        				</div>
				        <!-- Add Scroll Bar -->
				        <div class="swiper-scrollbar"></div>
    			</div>
            </div>
            
                
            
            
            
            
            
        </div>
    </div>

   
    <script type="text/javascript">

    $(function(){//页面元素加载完毕执行
    	//displayData(0);//查询movie信息
    	
         var swiper = new Swiper('#mainSwiper', {
            pagination: '.swiper-pagination',
            paginationClickable: true,
            slidesPerView: 'auto',
            parallax: true,
        });  
    	
         var swiper = new Swiper('#ziyuanSwiper-1', {
             scrollbar: '.swiper-scrollbar',
             direction: 'vertical',
             slidesPerView: 'auto',
             mousewheelControl: true,
             freeMode: true
         });
         var swiper = new Swiper('#ziyuanSwiper-2', {
             scrollbar: '.swiper-scrollbar',
             direction: 'vertical',
             slidesPerView: 'auto',
             mousewheelControl: true,
             freeMode: true
         });
    });
    
    //为其他需求所调用的ajax请求数据的方法
    function displayData(pageNo){
    	document.activeElement.blur(); //H5页面关闭软键盘（让聚焦元素失焦）,防止了页面卡死
    	var addCount = 0;//声明要增加的高度个数,需将ajax设为同步
		//var pageSize = $("#pageSize").val();
		var pageSize = 6;
		$.ajax({
			url:"${pageContext.request.contextPath}/playMovie/getByPage.do",
			type:"post",
			cache:false,
			async: false,
			data:{
				"pageNo":pageNo+1,//springMVC可以直接使用这种方式传参
				"pageSize":pageSize,
				"retype":"play-movie",
				"searchkey":$("#searchInfo").val(),
				//"timepicker":new Date().getTime(),//清除缓存加时间戳
			},
			beforeSend:function(){
				$("#message").text("正在查找请稍后...");
				return true;
			}, 
			success:function(jsonObject){
				$("#movieInfoTBody").empty();
				//{"total":100,"dataList":[{"id":"","accountNo":"","name":"","createTime":"","expireTime":"","allowIps":"","lockStatusText":""},{},{}]}
				var total = jsonObject.total;
				if(total==0){
					$("#message").text("没有符合条件的资源");					
				}else{
					if($("#searchInfo").val()!=""){//如果是条件查询
						$("#message").text("查询结果如下:");
					}else{
						$("#message").text("电影资源");
					}
					var htmlString = "";
					$.each(jsonObject.dataList,function(index,dom){
						/* 用ajax动态拼接表格
						要求是每行只能有2格，动态生成表格，经过分析发现
						第一行1,3,5与2除余1，第二行余0，把所有的表格看做一个递增的数字，
						这个数字就相当于所有td的下标（索引），根据这个数字与2的余数来拼接表格
						，同时注意，这个数字如果等于了要拼接的数量就要封口。从后台接收list作为电影集合
						模板格式：介绍最大字数限制32、名称最大字数限制10
						<tr>
	                	<td style="width: 160px;height: 130px;">
		                	<div style="position:relative">
				                <img src="http://192.168.173.1/re-pic/play-movie-pic/001 (4).png" 
				                style="width: 160px;height: 100px;" onclick="jumpPlay()"/>
				                <div style="color:white;font-size: 15px;position: absolute;top: 80px;left: 3px;z-index: 2;">阿凡达1</div>
		                	</div>
		                	<div style="width: 160px;height: 30px;">
		                		<div style="color:white;font-size:10px">人类与潘多拉星球上土著民发生的故事土著民发生的故事土著民发生的故事</div>
		                	</div>
	                	</td>
	                	<td style="width: 160px;height: 130px;">
		                	<div style="position:relative">
				                <img src="http://192.168.173.1/re-pic/play-movie-pic/001 (5).png" 
				                style="width: 160px;height: 100px;"/>
				                <div style="color:white;font-size: 15px;position: absolute;top: 80px;left: 3px;z-index: 2;">阿凡达2</div>
		                	</div>
		                	<div style="width: 160px;height: 30px;">
		                		<div style="color:white;font-size:10px">人类与潘</div>
		                	</div>
	                	</td>
	                </tr>
						*/
						
						if(index%2==0){//说明是首列，根据模板格式拼接。这个index从0开始
							htmlString += "<tr><td style='width:160px;height: 122px;'><div style='position:relative'>";
							htmlString += "<img src='"+dom.picpath+"'style='width: 160px;height: 100px;' onclick='jumpPlay(\""+ dom.reid +"\")'/>"; 
							htmlString += "<div style='color:white;font-size:15px;position:absolute;top:80px;left:3px;z-index:2;'>"+dom.showname+"</div></div>";
							htmlString += "<div style='width:160px;height:22px;'>";
							htmlString += "<div style='color:white;font-size:10px'>"+dom.searchkey+"</div></div></td>";
		                	if(index==total){//如果首列结束
		                		htmlString += "</tr><tr><td style='width:160px;height:100px;'></td></tr>";
		                	}
		                	addCount++;//每循环一次自增1只有在首列时自增1
						}
						
						if(index%2==1){//说明是尾列，尾列必有结束</tr>,没有开始<tr>
							htmlString += "<td style='width:160px;height: 122px;'><div style='position:relative'>";
							htmlString += "<img src='"+dom.picpath+"'style='width: 160px;height: 100px;' onclick='jumpPlay(\""+ dom.reid +"\")'/>";
							htmlString += "<div style='color:white;font-size:15px;position:absolute;top:80px;left:3px;z-index:2;'>"+dom.showname+"</div></div>";
							htmlString += "<div style='width:160px;height:22px;'>";
							htmlString += "<div style='color:white;font-size:10px'>"+dom.searchkey+"</div></div></td></tr>";
						}
					});//each结束
					$("#movieInfoTBody").append(htmlString);
				}//else结束
				
				//集成jquery翻页插件
				$("#pagination").pagination(jsonObject.total, {//总记录条数
		             callback: displayData,//每次翻页执行的回调函数,会传递页码的索引作为参数  注意:索引比正常页码小1
		             items_per_page:pageSize, // 每页显示多少条数据
		             current_page:pageNo,//当前页码索引
		             link_to:"javascript:void(0);",//保留超链接的样式 	执行js代码,但是不跳转到任何资源
		             num_display_entries:4,//页面过多的时候显示入口的个数
		             next_text:">",
		             prev_text:"<",
		             next_show_always:true,//没有下一页是否显示链接
		             prev_show_always:true,//没有上一页是否显示链接
		             num_edge_entries:0,//页码过多的时候  用...省略
		             ellipse_text:"..."//指定省略符号
		         });
				//设置总记录条数
				$("#total").text(jsonObject.total);
				//总页数
				var pageCount = jsonObject.total%pageSize==0?jsonObject.total/pageSize:parseInt(jsonObject.total/pageSize)+1;
				$("#pageCount").text(pageCount);
			} //success结束
			
		});//ajax结束,ajax结束之后才会刷新页面
		//alert(addCount);
		//加载影片完成重新设定高度
		var newHeight = addCount*130+340;
		addCount = 0; //重新归零
		$("#commenDiv").height("1000");
		//重新创建swiper，因为过去的会失效，同时保证计算的页高度正确结合重新设定高度方法实现，直接在这里初始化sWiper
		 var swiper = new Swiper('#ziyuanSwiper-1', {
    		scrollbar: '.swiper-scrollbar',
            direction: 'vertical',
            slidesPerView: 'auto',
            mousewheelControl: true,
            freeMode: true
        });
         var swiper = new Swiper('#mainSwiper', {
            pagination: '.swiper-pagination',
            paginationClickable: true,
            slidesPerView: 'auto',
            parallax: true,
        });  
		
	} //function结束
    
    function jumpPlay(reid){//发送id重新查找
    	//"http://192.168.173.1:8080/ms/playMovie/play.do";
    	window.location.href="http://192.168.173.1:8080/ms/playMovie/play.do"+"?reid="+reid;
    }
    </script>
</body>
</html>