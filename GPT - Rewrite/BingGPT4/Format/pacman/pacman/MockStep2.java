package com.yeshj.pacman.task.mock;

import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;

public class MockStep2 extends StepBase {

	@Override
	public Object execute(ExecuteContext context) throws Exception {
		Thread.sleep(2000);
		int p2 = context.getAttribute("p2", 0);
		int result = context.getAttribute("steps.result", 0);
		context.setAttribute("steps.result", p2 + result);
		return "ok";
	}

	@Override
	public String name() {
		return "mock.step.2";
	}
}
