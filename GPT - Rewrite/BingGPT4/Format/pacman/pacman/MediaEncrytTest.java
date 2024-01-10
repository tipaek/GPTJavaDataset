package com.yeshj.pacman;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.yeshj.pacman.utils.FileHelper;

public class MediaEncryptTest {

	private MediaEncrypt mediaEncrypt;

	@Before
	public void setUp() {
		mediaEncrypt = new MediaEncrypt();
	}

	@After
	public void tearDown() {
		mediaEncrypt = null;
	}

	@Test
	public void testEncode() {
		String sourceFile = "e:/1.zip";
		String encodedFile = "e:/1.data";
		mediaEncrypt.encodeMedia(sourceFile, encodedFile);
		assertTrue(FileHelper.exists(encodedFile));
	}

	@Test
	public void testDecode() {
		String encodedFile = "e:/1.data";
		String decodedFile = "e:/11.zip";
		mediaEncrypt.decodeMedia(encodedFile, decodedFile);
		assertTrue(FileHelper.exists(decodedFile));
	}
}
