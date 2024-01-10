/********************************************************
 * Copyright © 2014 HuJiang.com. All rights reserved.
 *
 * @Title: SystemMonitorStep.java
 * @Prject: libTask
 * @Package: com.yeshj.pacman.schedule.step
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2014年12月24日 上午10:17:10
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.schedule.step;

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;
import com.yeshj.pacman.schedule.SystemInfo;
import com.yeshj.pacman.utils.ProcessExecutor;

public class SystemMonitorStep extends StepBase {

	private static final ILog logger = LogFactory.getLog(SystemMonitorStep.class);
	private static final String CMDLINE = "top -bn1 -d 0.1";

	@Override
	public Object execute(ExecuteContext context) throws Exception {

		ProcessExecutor processExecutor = new ProcessExecutor();
		List<String> output = new ArrayList<>();
		String item;
		StringTokenizer tokenizer;
		SystemInfo systemInfo = new SystemInfo();

		if (processExecutor.execute(output, CMDLINE)) {

			try {

				for (String line : output) {

					if (line.startsWith("Cpu(s):")) {

						boolean isFragmentedFormat = line.indexOf("%us,") > 0;

						tokenizer = new StringTokenizer(line);
						tokenizer.nextToken();
						item = tokenizer.nextToken(); // user
						systemInfo.setCpuUser(Double.parseDouble(
								item.substring(0, item.indexOf('%'))));

						if (!isFragmentedFormat) {
							tokenizer.nextToken();
						}
						item = tokenizer.nextToken(); // sys
						systemInfo.setCpuSys(Double.parseDouble(
								item.substring(0, item.indexOf('%'))));

						if (!isFragmentedFormat) {
							tokenizer.nextToken();
						}

						item = tokenizer.nextToken(); // nice
						systemInfo.setCpuNice(Double.parseDouble(
								item.substring(0, item.indexOf('%'))));

						if (!isFragmentedFormat) {
							tokenizer.nextToken();
						}
						item = tokenizer.nextToken(); // idle
						systemInfo.setCpuIdle(Double.parseDouble(
								item.substring(0, item.indexOf('%'))));

					} else if (line.startsWith("Mem:")) {

						tokenizer = new StringTokenizer(line);
						tokenizer.nextToken();
						item = tokenizer.nextToken(); // total
						systemInfo.setMemTotal(Long.parseLong(
								item.substring(0, item.indexOf('k'))));

						tokenizer.nextToken();
						item = tokenizer.nextToken(); // used
						systemInfo.setMemUsed(Long.parseLong(
								item.substring(0, item.indexOf('k'))));

						tokenizer.nextToken();
						item = tokenizer.nextToken(); // free
						systemInfo.setMemFree(Long.parseLong(
								item.substring(0, item.indexOf('k'))));

						if (systemInfo.getMemTotal() > 0) {
							systemInfo.setMemUsage(systemInfo.getMemUsed() * 100.0d / systemInfo.getMemTotal());
						}
					}
				}
			} finally {
				// logger.info("CPU:" + systemInfo.getCpuUser() + " " + systemInfo.getCpuSys() +
				// " " + systemInfo.getCpuIdle());
				// logger.info("MEM:" + systemInfo.getMemTotal() + " " +
				// systemInfo.getMemUsage() + " " + systemInfo.getMemFree());
			}
		}

		return systemInfo;
	}

	@Override
	public String name() {
		return "step.system.monitor";
	}
}
