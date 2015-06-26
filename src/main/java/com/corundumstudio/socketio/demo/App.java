package com.corundumstudio.socketio.demo;

import java.util.Collection;
import java.util.Iterator;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

public class App {
	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(8088);
		
		SocketIOServer server = new SocketIOServer(config);
		CharteventListener listener = new CharteventListener();
		listener.setServer(server);
		server.addEventListener("chatevent", CharObject.class, listener);
		
		Collection<SocketIOClient> collectionList=  server.getAllClients();
		Iterator<SocketIOClient> it =	collectionList.iterator();
		server.start();
		Thread.sleep(Integer.MAX_VALUE);
		server.stop();
	}
}
