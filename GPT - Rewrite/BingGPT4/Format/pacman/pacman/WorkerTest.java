/********************************************************
 * Copyright © 2014 HuJiang.com. All rights reserved.
 *
 * @Title: WorkerTest.java
 * @Prject: libTask
 * @Package: com.yeshj.pacman.task.test
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2014年12月25日 下午3:44:06
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.task.test;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yeshj.pacman.schedule.IWorker;
import com.yeshj.pacman.schedule.IWorkerPool;
import com.yeshj.pacman.schedule.impl.DefaultWorkerPool;

public class WorkerTest {

	private BeanFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("schedules.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	boolean isFlagSet = false;

	@Test
	public void testWorkerPool() throws InterruptedException, ExecutionException {

		Runnable r = new Runnable() {

			@Override
			public void run() {

				try {
					Thread.sleep(2000);
					isFlagSet = true;
				} catch (InterruptedException e) {

					isFlagSet = false;
				}
			}
		};

		DefaultWorkerPool pool = new DefaultWorkerPool();

		Future<?> result = pool.submit(r);

		assertFalse(isFlagSet);
		result.get();
		assertTrue(isFlagSet);
	}

	@Test
	public void testMultipleStepsWorker() throws InterruptedException, ExecutionException {

		IWorkerPool pool = new DefaultWorkerPool();
		IWorker worker = (IWorker) factory.getBean("complex");
		worker.setAttribute("p1", 1);
		worker.setAttribute("p2", 2);
		worker.setAttribute("p3", 3);
		Future<?> result = pool.submit(worker);

		result.get();

		int re = worker.getAttribute("steps.result");

		assertEquals(6, re); // p1 + p2 + p3
	}

	@Test
	public void testSingleStepWorker() throws Exception {

		IWorkerPool pool = new DefaultWorkerPool();
		IWorker worker = (IWorker) factory.getBean("worker1");
		IWorker worker2 = (IWorker) factory.getBean("worker2");

		worker.setAttribute("p1", 1);
		worker2.setAttribute("p2", 2);
		Future<?> result = pool.submit(worker);
		Future<?> result2 = pool.submit(worker2);
		result.get();
		int re = worker.getAttribute("steps.result");

		assertEquals(1, re);

		result2.get();
		re = worker2.getAttribute("steps.result");
		assertEquals(2, re);

		worker.setAttribute("p2", 2);
	}
}
