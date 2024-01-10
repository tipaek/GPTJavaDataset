package com.yeshj.pacman.schedule.step;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;
import com.yeshj.pacman.utils.FileHelper;
import com.yeshj.pacman.utils.StringHelper;
import com.yeshj.pacman.utils.WebHelper;

public class ResourceProcessingStep extends StepBase {

	@Override
	public Object execute(ExecuteContext context) throws Exception {
		List<String> resList = context.getAttribute(Constants.CONTEXT_WEB_RESOURCES);
		String baseDir = context.getAttribute(Constants.CONTEXT_WEB_RESOURCES_TEMP_DIR);
		String mediaSrc = context.getAttribute(Constants.CONTEXT_MEDIA_PATH);
		String mediaTarget = FileHelper.combinePath(baseDir, StringHelper.getFileBareName(mediaSrc));
		String resTargetDir = context.getAttribute(Constants.CONTEXT_WEB_RESOURCES_TARGET_DIR);

		logger.info("===>" + mediaSrc + " >> " + mediaTarget);
		FileHelper.copyFile(mediaSrc, mediaTarget);

		context.setAttribute(Constants.CONTEXT_MEDIA_PATH, mediaTarget);
		List<String> newList = new ArrayList<>();

		String target, pubfile;
		if (resList != null) {
			for (String res : resList) {
				logger.info("=========>" + res);
				if (WebHelper.isWebResource(res)) {
					URL uri = new URL(res);
					target = FileHelper.combinePath(baseDir, uri.getFile());
					WebHelper.download(res, target);
					pubfile = FileHelper.combinePath(resTargetDir, uri.getFile());
					FileHelper.copyFile(target, pubfile);
				} else {
					target = FileHelper.combinePath(baseDir, StringHelper.getFileBareName(res));
					FileHelper.copyFile(res, target);
				}
				newList.add(target);
			}
		}

		context.setAttribute(Constants.CONTEXT_WEB_RESOURCES, newList);
		return null;
	}

	@Override
	public String name() {
		return "web.resource.process.step";
	}
}
