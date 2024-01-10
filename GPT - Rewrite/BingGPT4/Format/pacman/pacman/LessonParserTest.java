package com.yeshj.pacman.task.test;

import com.yeshj.pacman.schedule.dom.LessonInfo;
import com.yeshj.pacman.schedule.dom.LessonInfoParser;
import com.yeshj.pacman.utils.FileHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LessonParserTest {

	@Before
	public void setUp() throws Exception {
		// Setup code goes here...
	}

	@After
	public void tearDown() throws Exception {
		// Teardown code goes here...
	}

	@Test
	public void testLessonParser() throws Exception {
		String clazzpath = this.getClass().getResource("/").toString();
		LessonInfo info = new LessonInfoParser().parseAndSave(clazzpath + "/lesson.xml", "e:/lesson.xml");

		assertNotNull(info);
		assertEquals(140118, info.getClassID());
		assertEquals(253772, info.getLessonID());
		assertEquals("100010040.mp3", info.getMedia());
		assertEquals(3, info.getMediaType());
		assertEquals("LessonName", info.getLessonName());
		assertTrue(info.getAllFiles().size() > 0);
		assertTrue(FileHelper.exists("e:/lesson.xml"));
	}

	@Test
	public void testTrimToBareName() throws Exception {
		String url = "http://www.hujiang.com/abc/132/3kjd/1.mp3";
		LessonInfoParser parser = new LessonInfoParser();
		assertEquals("1", parser.trimToBareName(url));

		url = "hi$$so__i23.mp4";
		assertEquals("hi$$so__i23", parser.trimToBareName(url));
	}
}
