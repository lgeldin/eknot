package org.eknot;

import org.eknot.communication.Server;
import org.eknot.communication.ServerPing;
import org.eknot.lookup.NoIPServerProvider;
import org.eknot.lookup.NoIPServerPublisher;
import org.eknot.lookup.ServerInfo;
import org.eknot.lookup.ServerListManager;
import org.eknot.lookup.ServerListProvider;
import org.eknot.lookup.ServerPublisher;

public class Main {
	public static void main(String[] args) {
		Server serverInstance = new Server();
		serverInstance.start();

		// Repeat this:
		ServerListManager serverListManager = new ServerListManager();
		ServerListProvider provider = new NoIPServerProvider();
		serverListManager.addAllServers(provider.getServers());

		ServerPing ping = new ServerPing();
		boolean found = false;
		for (ServerInfo server : serverListManager.getServers()) {
			if (ping.ping(server)) {
				System.out.println(server.getIpAddress() + ":-)");
				found = true;
			} else {
				System.out.println(server.getIpAddress() + ":-(");
			}
		}

		if (!found) {
			ServerPublisher publisher = new NoIPServerPublisher();
			publisher.publish();
		}
	}
}
