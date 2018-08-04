package web;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class ServerSocket extends WebSocketServer {

    private ServerManager _serverManager;

    public ServerSocket(ServerManager serverManager,int port) throws UnknownHostException{
        super(new InetSocketAddress(port));     
        _serverManager=serverManager;
    }

    @Override
    public void onClose(WebSocket socket, int message,
            String reason, boolean remote) {
        _serverManager.UserLeave(socket);
    }

    @Override
    public void onError(WebSocket socket, Exception message) {
        System.out.println("Socket Exception:"+message.toString());
    }

    @Override
    public void onMessage(WebSocket socket, String message) {
        System.out.println("OnMessage:"+message.toString());


    }

    @Override
    public void onOpen(WebSocket socket, ClientHandshake handshake) {
        System.out.println("Some one Connected...");
        String hostAddress = socket.getRemoteSocketAddress().getAddress().getHostAddress();
        System.out.println(hostAddress);
        String hostName = socket.getRemoteSocketAddress().getHostName();
        System.out.println(hostName);
        _serverManager.UserLogin(hostAddress, socket);
        
    }

}