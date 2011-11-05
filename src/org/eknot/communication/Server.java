package org.eknot.communication;

import org.eknot.lookup.ServerInfo;

public interface Server {
	
	public boolean ping(ServerInfo destination);

}
