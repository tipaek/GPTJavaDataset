package com.yeshj.pacman.log;

public interface ILog {

	/**
	 * Logs an informational message.
	 *
	 * @param msg the message to log
	 */
	void info(String msg);

	/**
	 * Logs an informational message along with a throwable.
	 *
	 * @param msg the message to log
	 * @param t   the throwable to log
	 */
	void info(String msg, Throwable t);

	/**
	 * Logs a warning message.
	 *
	 * @param msg the message to log
	 */
	void warn(String msg);

	/**
	 * Logs a warning message along with a throwable.
	 *
	 * @param msg the message to log
	 * @param t   the throwable to log
	 */
	void warn(String msg, Throwable t);

	/**
	 * Logs an error message.
	 *
	 * @param msg the message to log
	 */
	void error(String msg);

	/**
	 * Logs an error message along with a throwable.
	 *
	 * @param msg the message to log
	 * @param t   the throwable to log
	 */
	void error(String msg, Throwable t);
}
