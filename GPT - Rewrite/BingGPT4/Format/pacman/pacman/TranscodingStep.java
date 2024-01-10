/********************************************************
 * Copyright © 2015 HuJiang.com. All rights reserved.
 *
 * @Title: TranscodingStep.java
 * @Prject: libTask
 * @Package: com.yeshj.pacman.schedule.step
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2015年1月5日 上午10:01:40
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.schedule.step;

import java.io.FileNotFoundException;

import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;
import com.yeshj.pacman.schedule.StepExecuteException;
import com.yeshj.pacman.utils.ExternalTool;
import com.yeshj.pacman.utils.FileHelper;
import com.yeshj.pacman.utils.ProcessExecutor;

public class TranscodingStep extends StepBase {

	private final static String PREFIX = "[TranscodingStep] ";

	@Override
	public Object execute(ExecuteContext context) throws Exception {

		boolean isAudioOnly = context.getAttribute(Constants.CONTEXT_AUDIONLY, true);

		if (isAudioOnly) {
			decodeAudio(context);
		} else {
			decodeVideo(context);
		}

		return null;
	}

	private void decodeVideo(ExecuteContext context) throws Exception {

		String videoCodec = context.getAttribute(Constants.CONTEXT_VIDEO_CODEC);
		String audioCodec = context.getAttribute(Constants.CONTEXT_AUDIO_CODEC);
		int videoBitrate = context.getAttribute(Constants.CONTEXT_VIDEO_BITRATE);
		int audioBitrate = context.getAttribute(Constants.CONTEXT_AUDIO_BITRATE);
		int audioSampling = context.getAttribute(Constants.CONTEXT_SAMPLING, 0);

		String videoSource = context.getAttribute(Constants.CONTEXT_MEDIA_PATH);
		String videoDestination = context.getAttribute(Constants.CONTEXT_MEDIA_FULLPATH);

		if (!FileHelper.exists(videoSource)) {
			throw new FileNotFoundException(videoSource);
		}

		FileHelper.ensureExists(videoDestination, true);

		String command = ExternalTool.buildVideoCommand(
				videoCodec, audioCodec, videoBitrate, audioBitrate, audioSampling, videoSource, videoDestination);

		logger.info(PREFIX + " CMD:" + command);
		ProcessExecutor processExecutor = new ProcessExecutor();
		if (processExecutor.runShell(command)) {

			logger.info(PREFIX + " execute successfully!");
		} else {

			logger.error(PREFIX + " execute fail!\n");
			throw new StepExecuteException();
		}
	}

	private void decodeAudio(ExecuteContext context) throws Exception {

		String audioCodec = context.getAttribute(Constants.CONTEXT_AUDIO_CODEC);
		int audioBitrate = context.getAttribute(Constants.CONTEXT_AUDIO_BITRATE, 0);
		int audioSampling = context.getAttribute(Constants.CONTEXT_SAMPLING, 0);
		int audioDuration = context.getAttribute(Constants.CONTEXT_DURATION, 0);

		String audioSource = context.getAttribute(Constants.CONTEXT_MEDIA_PATH);
		String audioDestination = context.getAttribute(Constants.CONTEXT_MEDIA_FULLPATH);

		if (!FileHelper.exists(audioSource)) {
			throw new FileNotFoundException(audioSource);
		}

		FileHelper.ensureExists(audioDestination, true);

		String command = ExternalTool.buildAudioCommand(
				audioCodec, audioBitrate, audioSampling, audioDuration, audioSource, audioDestination);

		logger.info(PREFIX + " CMD:" + command);

		ProcessExecutor processExecutor = new ProcessExecutor();
		if (processExecutor.runShell(command)) {

			logger.info(PREFIX + " execute successfully!");
		} else {

			logger.error(PREFIX + " execute fail!\n");
			throw new StepExecuteException();
		}
	}
}
