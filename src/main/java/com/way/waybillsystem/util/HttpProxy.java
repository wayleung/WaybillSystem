package com.way.waybillsystem.util;

/**
 * @author ASNPHPQ
 * 
 * add by xiejun
 *
 */
public class HttpProxy {
	
	private boolean isProxy = false;
	
	private String address;
	
	private int port;

	public boolean isProxy() {
		return isProxy;
	}

	public void setProxy(boolean isProxy) {
		this.isProxy = isProxy;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "HttpProxy [isProxy=" + isProxy + ", address=" + address
				+ ", port=" + port + "]";
	}
	
	
}
