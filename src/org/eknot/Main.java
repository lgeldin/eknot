package org.eknot;

import org.eknot.communication.Server;
import org.eknot.communication.SimpleServer;
import org.eknot.lookup.NoIPServerProvider;
import org.eknot.lookup.NoIPServerPublisher;
import org.eknot.lookup.ServerInfo;
import org.eknot.lookup.ServerListManager;
import org.eknot.lookup.ServerListProvider;
import org.eknot.lookup.ServerPublisher;

public class Main {
	public static void main(String[] args) {
		
		// Repeat this:
		ServerListManager serverListManager = new ServerListManager();
		ServerListProvider provider = new NoIPServerProvider();
		serverListManager.addAllServers(provider.getServers());

		for (ServerInfo server : serverListManager.getServers()) {
			publishIfNotReachable(server, 3);
		}
		
	}
	
	private static void publishIfNotReachable(ServerInfo server, int attempts){
		
		if(attempts == 0){
			return;
		}
		
		Server serverInstance = SimpleServer.getInstance();
		
		if (serverInstance.ping(server)) {
			
			System.out.println(server.getIpAddress() + ":-(");
			
			ServerPublisher publisher = new NoIPServerPublisher();
			publisher.publish();

			publishIfNotReachable(server, attempts -1);
		}else{
			System.out.println(server.getIpAddress() + ":-)");
		}
		
	}
	
	
}
