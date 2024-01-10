package com.yeshj.pacman.schedule;

public class StepExecuteException extends Exception {

	private static final long serialVersionUID = -1655148019297631813L;

	public StepExecuteException() {
		super();
	}

	public StepExecuteException(String msg) {
		super(msg);
	}

	public StepExecuteException(String msg, Exception innerException) {
		super(msg, innerException);
	}
}
