package org.eknot.lookup;

import java.util.ArrayList;
import java.util.List;

public class ServerListManager {
	private List<ServerInfo> servers = new ArrayList<ServerInfo>();

	public void addServer(ServerInfo server) {
		servers.add(server);
	}

	public List<ServerInfo> getServers() {
		return servers;
	}

	public void addAllServers(List<ServerInfo> additionalServers) {
		this.servers.addAll(additionalServers);
	}
}
