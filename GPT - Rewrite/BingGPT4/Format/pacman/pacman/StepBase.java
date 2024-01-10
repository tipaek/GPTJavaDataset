package com.yeshj.pacman.schedule;

import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;

public abstract class StepBase implements IStep {

	protected static final ILog logger = LogFactory.getLog(StepBase.class);

	@Override
	public void beforeExecute(ExecuteContext context) {
		logger.info(String.format("step[%s] started!", name()));
		context.timeOn();
	}

	@Override
	public void afterExecute(ExecuteContext context) {
		context.setLastExecuteDuration(context.timeOff() / 1000);
		logger.info(String.format("step[%s] executed[%d ms]", name(), context.getLastExecuteDuration() / 1000));
	}
}
