package com.yeshj.pacman.schedule;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class InnerWorkerPool extends ThreadPoolExecutor implements IWorkerPool {

	public static final String WORKER_CALLBACK = "worker.callback";
	public static final String WORKER_POOL = "worker.pool";

	public InnerWorkerPool(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public abstract void callback(ExecuteContext context);
}
