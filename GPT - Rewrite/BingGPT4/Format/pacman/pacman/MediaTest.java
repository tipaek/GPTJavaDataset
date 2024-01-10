package com.yeshj.pacman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MediaTest {

	private MediaInfo mediaInfo;

	@Before
	public void setUp() {
		mediaInfo = new MediaInfo();
	}

	@After
	public void tearDown() {
		mediaInfo = null;
	}

	@Test
	public void testMp3() {
		mediaInfo.analyzeMedia("e:\\mp3\\mww.mp3");
		assertEquals("mpeg audio", mediaInfo.getMediaTypeKey());
		System.out.println("bitrate:" + mediaInfo.getAudioBitrate());
		System.out.println("duration:" + mediaInfo.getAudioDuration());
		System.out.println("codec:" + mediaInfo.getAudioFormat());
		System.out.println("sample:" + mediaInfo.getAudioSamplingRate());
		assertTrue(mediaInfo.getAudioBitrate() > 0);
		assertEquals(44100, mediaInfo.getAudioSamplingRate());
	}

	@Test
	public void testMp4() {
		mediaInfo.analyzeMedia("E:\\video\\2.mp4");
		String mediaType = mediaInfo.getMediaTypeKey();
		String audioCodec = mediaInfo.getAudioFormat();
		String videoCodec = mediaInfo.getVideoFormat();
		int audioBitrate = mediaInfo.getAudioBitrate();
		int videoBitrate = mediaInfo.getVideoBitrate();

		assertEquals("mpeg audio", mediaType);
		assertNotEquals("", audioCodec);
		assertNotEquals("", videoCodec);
		assertTrue(audioBitrate > 0);
		assertTrue(videoBitrate > 0);
	}
}
