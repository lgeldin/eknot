package org.eknot.lookup;

import java.net.HttpURLConnection;
import java.net.InetAddress;

public class ServerListProvider {
	private void publishIP() {
		// GET /nic/update?hostname=mytest.testdomain.com&myip=1.2.3.4 HTTP/1.0
		// Host: dynupdate.no-ip.com
		// Authorization: Basic base64-encoded-auth-string
		// User-Agent: Bobs Update Client WindowsXP/1.2 bob@somedomain.com

		// http://lgel@walla.co.il:try24me@dynupdate.no-ip.com/nic/update?hostname=lgel-host1.no-ip.org&myip=1.2.3.4
		// lgel-host1.no-ip.org

		// good IP_ADDRESS Success DNS hostname update successful. Followed by a
		// space and the IP address it was updated to.

		// nochg IP_ADDRESS Success IP address is current, no update performed.
		// Followed by a space and the IP address that it is currently set to.

		// nohost Error Hostname supplied does not exist under specified
		// account, client exit and require user to enter new login credentials
		// before performing and additional request.

		// badauth Error Invalid username password combination

		// badagent Error Client disabled. Client should exit and not perform
		// any more updates without user intervention.

		// !donator Error An update request was sent including a feature that is
		// not available to that particular user such as offline options.

		// abuse Error Username is blocked due to abuse. Either for not
		// following our update specifications or disabled due to violation of
		// the No-IP terms of service. Our terms of service can be viewed at
		// http://www.no-ip.com/legal/tos. Client should stop sending updates.

		// 911 Error A fatal error on our side such as a database outage. Retry
		// the update no sooner 30 minutes.
	}

	public static void main(String[] args) {
		try {
			java.net.URL URL = new java.net.URL("http://www.whatismyip.org/");
			java.net.HttpURLConnection Conn = (HttpURLConnection) URL
					.openConnection();
			java.io.InputStream InStream = Conn.getInputStream();

			java.io.InputStreamReader Isr = new java.io.InputStreamReader(
					InStream);

			java.io.BufferedReader Br = new java.io.BufferedReader(Isr);

			System.out.println("Your IP address is " + Br.readLine());
			// http://lgel@walla.co.il:try24me@dynupdate.no-ip.com/nic/update?hostname=lgel-host1.no-ip.org&myip=1.2.3.4

			InetAddress addr = InetAddress.getLocalHost();

			// Get IP Address
			byte[] ipAddr = addr.getAddress();

			// Get hostname
			String hostname = addr.getHostName();
			System.out.println(hostname);
			int i1 = 255 & ipAddr[0];
			int i2 = 255 & ipAddr[1];
			System.out.println(i1 + ":" + i2);
			System.out.println(addr.getHostAddress());

			InetAddress addr2 = InetAddress.getByName("lgel-host1.no-ip.org");
			System.out.println(addr2.getHostAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
