package com.yeshj.pacman.utils;

public class ShellCommand {

	private final StringBuilder cmdBuffer;

	private ShellCommand(String cmd) {
		cmdBuffer = new StringBuilder(cmd);
	}

	public static ShellCommand create(String cmd) {
		return new ShellCommand(cmd);
	}

	public <T> ShellCommand add(T opt) {
		cmdBuffer.append(" ").append(String.valueOf(opt));
		return this;
	}

	public <T> ShellCommand add(String key, T opt) {
		cmdBuffer.append(String.format(" %s %s", key, String.valueOf(opt)));
		return this;
	}

	@Override
	public String toString() {
		return cmdBuffer.toString();
	}
}
