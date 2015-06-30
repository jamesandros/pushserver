package com.corundumstudio.socketio.demo;

import java.util.Iterator;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class ChatLauncher {

    public static void main(String[] args) throws InterruptedException {

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

        final SocketIOServer server = new SocketIOServer(config);
        server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                // broadcast messages to all clients
            	System.out.println(client.getSessionId());
               // server.getBroadcastOperations().sendEvent("chatevent", data);
            	Iterator<SocketIOClient> list= server.getAllClients().iterator();
            	while(list.hasNext()){
            		System.out.println(list.next().getSessionId());
            	}
            }
        });
        server.start(); 
        server.addConnectListener(new ConnectListener() {
			public void onConnect(SocketIOClient client) {
				System.out.println("已经连接上了");
			}
		});
        server.addDisconnectListener(new DisconnectListener() {
			public void onDisconnect(SocketIOClient client) {
				System.out.println(client.getSessionId());
				System.out.println("该用户已离线");
			}
		});
    }

}
