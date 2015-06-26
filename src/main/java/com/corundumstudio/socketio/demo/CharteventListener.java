package com.corundumstudio.socketio.demo;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class CharteventListener implements DataListener<CharObject> {

	SocketIOServer server;
	
	public void setServer(SocketIOServer server) {
		this.server = server;
	}
	public void onData(SocketIOClient client, CharObject data,
			AckRequest ackSender) throws Exception {
		System.out.println(data);
		System.out.println(this.server.getAllClients().size());
		this.server.getBroadcastOperations().sendEvent("chatevent", data);
	}

}
