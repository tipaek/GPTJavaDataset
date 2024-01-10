package com.yeshj.pacman.schedule;

import com.yeshj.pacman.annotation.Transmit;

public class SystemInfo {

	@Transmit(key = "ip")
	private String ip;

	@Transmit(key = "user")
	private double cpuUser;

	@Transmit(key = "sys")
	private double cpuSys;

	@Transmit(key = "nice")
	private double cpuNice;

	@Transmit(key = "idle")
	private double cpuIdle;

	@Transmit(key = "total")
	private long memTotal;

	@Transmit(key = "used")
	private long memUsed;

	@Transmit(key = "free")
	private long memFree;

	@Transmit(key = "usage")
	private double memUsage;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public double getCpuUser() {
		return cpuUser;
	}

	public void setCpuUser(double cpuUser) {
		this.cpuUser = cpuUser;
	}

	public double getCpuSys() {
		return cpuSys;
	}

	public void setCpuSys(double cpuSys) {
		this.cpuSys = cpuSys;
	}

	public double getCpuNice() {
		return cpuNice;
	}

	public void setCpuNice(double cpuNice) {
		this.cpuNice = cpuNice;
	}

	public double getCpuIdle() {
		return cpuIdle;
	}

	public void setCpuIdle(double cpuIdle) {
		this.cpuIdle = cpuIdle;
	}

	public long getMemTotal() {
		return memTotal;
	}

	public void setMemTotal(long memTotal) {
		this.memTotal = memTotal;
	}

	public long getMemUsed() {
		return memUsed;
	}

	public void setMemUsed(long memUsed) {
		this.memUsed = memUsed;
	}

	public long getMemFree() {
		return memFree;
	}

	public void setMemFree(long memFree) {
		this.memFree = memFree;
	}

	public double getMemUsage() {
		return memUsage;
	}

	public void setMemUsage(double memUsage) {
		this.memUsage = memUsage;
	}
}
