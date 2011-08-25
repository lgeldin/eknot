package org.eknot.lookup;

import java.util.Date;

public class ServerInfo {
	private IPAddress ipAddress;
	private Boolean alive;
	private Integer port;
	private Date lastActivity;
	private Boolean behindNAT;// TODO: rename

	public ServerInfo(IPAddress ipAddress) {
		setIpAddress(ipAddress);
	}
	public IPAddress getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(IPAddress ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Date getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}

}
