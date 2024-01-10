package com.yeshj.pacman.task.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.SystemInfo;
import com.yeshj.pacman.schedule.step.SystemMonitorStep;

public class SysMonitorTest {

	@Before
	public void setUp() {
		// Setup code can go here
	}

	@After
	public void tearDown() {
		// Cleanup code can go here
	}

	@Test
	public void testSysInfo() throws Exception {
		SystemMonitorStep monitor = new SystemMonitorStep();
		ExecuteContext context = new ExecuteContext();
		SystemInfo info = (SystemInfo) monitor.execute(context);
		assertNotNull(info);

		System.out.println("user:" + info.getCpuUser() + " sys:" + info.getCpuSys() +
				" nice:" + info.getCpuNice() + " idle:" + info.getCpuIdle());
		System.out.println("total:" + info.getMemTotal() + " used:" + info.getMemUsed() +
				" free:" + info.getMemFree());

		assertTrue(info.getCpuIdle() > 1.0d);
		assertTrue(info.getMemTotal() > 0);
		assertTrue(info.getMemFree() > 0);
	}
}
