package org.eknot.lookup;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class NoIPServerProvider implements ServerListProvider {

	public IPAddress getIP(int hostNumber) {
		return new IPAddress("eknot-host" + hostNumber + ".no-ip.org");
	}

	@Override
	public List<ServerInfo> getServers() {
		List<ServerInfo> result = new ArrayList<ServerInfo>();
		result.add(new ServerInfo(getIP(1)));
		result.add(new ServerInfo(getIP(2)));
		result.add(new ServerInfo(getIP(3)));
		result.add(new ServerInfo(getIP(4)));
		result.add(new ServerInfo(getIP(5)));
		return result;
	}
}
