/********************************************************
 * Copyright © 2014 HuJiang.com. All rights reserved.
 *
 * @Title: VideoTranscodingMessage.java
 * @Prject: libMsgLayer
 * @Package: com.yeshj.pacman.jms.model
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2014年12月24日 下午5:16:34
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.jms.message;

import com.yeshj.pacman.annotation.Transmit;

public class VideoTranscodingMessage extends BaseMessage {

	@Transmit(key = "aubr")
	protected int audioBitRate;

	@Transmit(key = "ausamr")
	protected int audioSamplingRate;

	@Transmit(key = "audur")
	protected int audioDuration;

	@Transmit(key = "acodec")
	protected String audioCodec;

	@Transmit(key = "vibr")
	protected int videoBitRate;

	@Transmit(key = "visamr")
	protected int videoSamplingRate;

	@Transmit(key = "vidur")
	protected int videoDuration;

	@Transmit(key = "width")
	protected int videoWidth;

	@Transmit(key = "vcodec")
	protected String videoCodec;

	@Transmit(key = "media")
	protected String mediaFile;

	@Transmit(key = "cid")
	protected int classId;

	@Transmit(key = "lid")
	protected int lessonId;

	@Transmit(key = "height")
	protected int videoHeight;

	@Transmit(key = "guid")
	protected String guid;

	public String getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(String mediaFile) {
		this.mediaFile = mediaFile;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getAudioBitRate() {
		return audioBitRate;
	}

	public String getAudioCodec() {
		return audioCodec;
	}

	public int getAudioDuration() {
		return audioDuration;
	}

	public int getAudioSamplingRate() {
		return audioSamplingRate;
	}

	public int getVideoDuration() {
		return videoDuration;
	}

	public int getVideoSamplingRate() {
		return videoSamplingRate;
	}

	public int getVideoBitRate() {
		return videoBitRate;
	}

	public String getVideoCodec() {
		return videoCodec;
	}

	public int getVideoHeight() {
		return videoHeight;
	}

	public int getVideoWidth() {
		return videoWidth;
	}

	public void setAudioBitRate(int audioBitRate) {
		this.audioBitRate = audioBitRate;
	}

	public void setAudioCodec(String audioCodec) {
		this.audioCodec = audioCodec;
	}

	public void setAudioDuration(int audioDuration) {
		this.audioDuration = audioDuration;
	}

	public void setAudioSamplingRate(int audioSamplingRate) {
		this.audioSamplingRate = audioSamplingRate;
	}

	public void setVideoDuration(int videoDuration) {
		this.videoDuration = videoDuration;
	}
}
