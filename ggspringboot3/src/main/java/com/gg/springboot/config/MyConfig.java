package com.gg.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="gg")
public class MyConfig {
	
	private  String root;
	private  String time;
	private String remotePort;
	
	private  static String ggRoot;
	private  static String ggTime;
	private static String ggRemotePort;
	
	public String getRemotePort() {
		return remotePort;
	}

	@Value("${gg.remote.port}")
	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
		setGgRemotePort(remotePort);
	}


	public static String getGgRemotePort() {
		return ggRemotePort;
	}


	public static void setGgRemotePort(String ggRemotePort) {
		MyConfig.ggRemotePort = ggRemotePort;
	}


	public String getRoot() {
		return root;
	}


	public void setRoot(String root) {
		this.root = root;
		setGgRoot(root);
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
		setGgTime(time);
	}

	public static String getGgRoot() {
		return ggRoot;
	}

	public static void setGgRoot(String ggRoot) {
		MyConfig.ggRoot = ggRoot;
	}

	public static String getGgTime() {
		return ggTime;
	}

	public static void setGgTime(String ggTime) {
		MyConfig.ggTime = ggTime;
	}





	
	
	
}
