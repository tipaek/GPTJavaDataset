package com.yeshj.pacman.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;

public class ProcessExecutor {

	private static final ILog logger = LogFactory.getLog(ProcessExecutor.class);
	public static final int SUCCESS = 0;

	public boolean execute(List<String> outList, String cmdFormat, Object... args) throws Exception {
		boolean result = false;
		String cmdline = String.format(cmdFormat, args);
		Process process = Runtime.getRuntime().exec(cmdline);
		result = process.waitFor() == SUCCESS;
		return result;
	}

	public boolean runShell(String shellCmd) {
		boolean result = false;
		StringBuilder sb = new StringBuilder();
		try {
			Process proc = Runtime.getRuntime().exec(shellCmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String line;
			result = proc.waitFor() == 0;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			logger.info(sb.toString());
		} catch (Exception e) {
			logger.error("runShell error!", e);
			result = false;
		}
		return result;
	}
}
