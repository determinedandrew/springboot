package service;

import org.java_websocket.WebSocket;

public class GeneralService {
	
	/**
	 * 请求格式
	 * {requestType:getMovieList,startNo:,pageSize:,}
	 * 
	 * 
	 * @description 定义基础传输协议，截取请求并分发，格式如下：
	 * {
	 * 
	 * mybranch1
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 0：无消息
	 * 1：gobang旗子返回
	 * 2：在线列表
	 * 3：邀请信息
	 * 4：同意信息1是0否
	 * 5：系统提示信息
	 * json格式：{"desIP":"127.0.0.1","srcIP":"127.0.0.1","messageType":"5","message":"系统提示信息"}
	 *  {"desIP":"127.0.0.1","srcIP":"","messageType":"2","message":["127.0.0.1","127.0.0.2"]}
	 * @param socket
	 * @param message
	 */
	public void dispatcherHandle(WebSocket socket, String message){
		
	}

}
