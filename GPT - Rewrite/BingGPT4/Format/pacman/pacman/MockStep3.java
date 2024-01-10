package com.yeshj.pacman.task.mock;

import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;

public class MockStep3 extends StepBase {

	@Override
	public Object execute(ExecuteContext context) throws Exception {
		Thread.sleep(3000);
		int p3 = context.getAttribute("p3", 0);
		int result = context.getAttribute("steps.result", 0);
		context.setAttribute("steps.result", p3 + result);
		return "ok";
	}

	@Override
	public String name() {
		return "mock.step.3";
	}
}
