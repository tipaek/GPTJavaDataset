package com.yeshj.pacman.log;

import org.apache.commons.logging.Log;

public class LogImpl implements ILog {

	private Log logger = null;

	protected LogImpl(Log log) {
		this.logger = log;
	}

	@Override
	public void info(String msg) {
		if (logger.isInfoEnabled())
			logger.info(msg);
	}

	@Override
	public void info(String msg, Throwable t) {
		if (logger.isInfoEnabled())
			logger.info(msg, t);
	}

	@Override
	public void warn(String msg) {
		if (logger.isWarnEnabled())
			logger.warn(msg);
	}

	@Override
	public void warn(String msg, Throwable t) {
		if (logger.isWarnEnabled())
			logger.warn(msg, t);
	}

	@Override
	public void error(String msg) {
		if (logger.isErrorEnabled())
			logger.error(msg);
	}

	@Override
	public void error(String msg, Throwable t) {
		if (logger.isErrorEnabled())
			logger.error(msg, t);
	}
}
