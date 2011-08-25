package org.eknot.lookup;

public class IPAddress {
	private String ip;

	public IPAddress(String ip) {
		super();
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return getIp();
	}
}
