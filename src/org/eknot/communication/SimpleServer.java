package org.eknot.communication;

import java.net.InetAddress;

import org.eknot.lookup.ServerInfo;

public class SimpleServer implements Server{
	
	private static SimpleServer instance;
	
	private final int pingTimeout = 10 * 1000;
	
	private SimpleServer(){}
	
	public static SimpleServer getInstance(){
		if(instance == null){
			instance = new SimpleServer();
		}
		return instance;
	}
	
	@Override
	/**
	 * This implementation of ping uses a tcp ping. When we decide which protocol we use for the communication,
	 * we should reimplement it
	 */
	public boolean ping(ServerInfo destination){
		try{
			InetAddress address = InetAddress.getByName(destination.getIpAddress().getIp());
			return address.isReachable(pingTimeout);
		}catch(Exception ex){
			return false;
		}
	}
}
