package com.yeshj.pacman.task.mock;

import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;

public class MockStep1 extends StepBase {

	@Override
	public Object execute(ExecuteContext context) throws Exception {
		Thread.sleep(1000);
		int p1 = context.getAttribute("p1", 0);
		int result = context.getAttribute("steps.result", 0);
		context.setAttribute("steps.result", result + p1);
		return "ok";
	}

	@Override
	public String name() {
		return "mock.step.1";
	}
}
