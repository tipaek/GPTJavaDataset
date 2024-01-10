package com.yeshj.pacman.schedule.step;

import com.yeshj.pacman.MediaEncrypt;
import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;
import com.yeshj.pacman.utils.FileHelper;
import com.yeshj.pacman.utils.StringHelper;

import java.io.FileNotFoundException;

public class MediaCryptoStep extends StepBase {

	@Override
	public Object execute(ExecuteContext context) throws Exception {
		String packfile = context.getAttribute(Constants.CONTEXT_MEDIA_PATH);
		String tempDir = context.getAttribute(Constants.CONTEXT_TEMP_DIR);
		boolean isFree = context.getAttribute(Constants.CONTEXT_ISFREE_CLASS);
		logger.info("isFree:" + isFree);
		if (!FileHelper.exists(packfile)) {
			throw new FileNotFoundException(packfile);
		}

		FileHelper.ensureExists(tempDir, false);

		MediaEncrypt encrypt = new MediaEncrypt();
		encrypt.encodeMedia(packfile, FileHelper.combinePath(tempDir, "index.dat"));

		if (isFree) {
			int class_id = context.getAttribute(Constants.CONTEXT_CLASS_ID);
			int lesson_id = context.getAttribute(Constants.CONTEXT_LESSON_ID);
			String targetDir = AppConfig.getInstance().getRawTargetDir() + "/" + class_id + "/" + lesson_id + "/";
			FileHelper.ensureExists(targetDir, false);
			String rawFileName = StringHelper.getFileBareName(packfile);
			FileHelper.copyFile(packfile, targetDir + rawFileName);
		}

		return null;
	}

	@Override
	public String name() {
		return "media.cypto.step";
	}
}
