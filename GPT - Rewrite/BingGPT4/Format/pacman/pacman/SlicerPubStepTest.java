package com.yeshj.pacman.task.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.step.SlicerPublishStep;
import com.yeshj.pacman.utils.FileHelper;

public class SlicerPubStepTest {

	@Before
	public void setUp() {
		// Setup code can go here
	}

	@After
	public void tearDown() {
		// Cleanup code can go here
	}

	@Test
	public void testNormal() throws Exception {
		FileHelper.ensureExists("e:\\out\\class_audio_mp3\\0\\", false);
		String xml = FileHelper.combinePath(this.getClass().getResource("/").toString(), "log4j.xml").replace("file:\\",
				"");
		FileHelper.copyFile(xml, "e:\\out\\class_audio_mp3\\0\\0.xml");
		FileHelper.copyFile("e:\\mp3\\mww.mp3", "e:\\out\\class_audio_mp3\\0.flv");
		ExecuteContext context = new ExecuteContext();
		context.setAttribute(Constants.CONTEXT_MEDIA_FULLPATH, "e:\\out\\class_audio_mp3\\0.flv");
		context.setAttribute(Constants.CONTEXT_SLICER_PUBLISH_PATH, "e:\\temp");
		SlicerPublishStep step = new SlicerPublishStep();
		step.execute(context);

		assertTrue(FileHelper.exists("e:\\temp\\0\\0.xml"));
		assertFalse(FileHelper.exists("e:\\out\\class_audio_mp3\\0"));

		FileHelper.deleteDir("e:\\temp\\0\\");
	}
}
