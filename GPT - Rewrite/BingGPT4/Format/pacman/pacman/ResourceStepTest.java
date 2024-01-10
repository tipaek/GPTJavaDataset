package com.yeshj.pacman.task.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.step.ResourceProcessingStep;
import com.yeshj.pacman.utils.FileHelper;

public class ResourceStepTest {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testPics() throws Exception {
		List<String> list = new ArrayList<>();
		list.add("http://f1.ct.hjfile.cn/image/event/201412/02152036689a723_w500.jpg");
		list.add("http://f1.ct.hjfile.cn/image/event/201404/10555_w500.jpg");
		list.add("http://f1.ct.hjfile.cn/image/event/201412/291513219925f06.jpg");
		list.add("http://f1.ct.hjfile.cn/image/event/201412/1714235198267a7_w500.jpg");
		list.add("http://f1.ct.hjfile.cn/image/event/201411/071721024409f7d.jpg");
		ExecuteContext context = new ExecuteContext();
		context.setAttribute(Constants.CONTEXT_WEB_RESOURCES, list);
		context.setAttribute(Constants.CONTEXT_WEB_RESOURCES_TARGET_DIR, "e:/temp/resource");

		ResourceProcessingStep step = new ResourceProcessingStep();
		step.execute(context);

		assertTrue(FileHelper.exists("e:/ttt/image/event/201412/02152036689a723_w500.jpg"));
		assertTrue(FileHelper.exists("e:/ttt/image/event/201404/10555_w500.jpg"));
		assertTrue(FileHelper.exists("e:/ttt/image/event/201412/291513219925f06.jpg"));
		assertTrue(FileHelper.exists("e:/ttt/image/event/201412/1714235198267a7_w500.jpg"));
		assertTrue(FileHelper.exists("e:/ttt/image/event/201411/071721024409f7d.jpg"));
	}
}
