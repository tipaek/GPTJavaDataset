package com.yeshj.pacman.schedule.step;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;
import com.yeshj.pacman.utils.FileHelper;

public class MediaPackStep extends StepBase {

	@Override
	public Object execute(ExecuteContext context) throws Exception {
		List<String> packFiles = new ArrayList<>();
		String tempDir = context.getAttribute(Constants.CONTEXT_TEMP_DIR);
		String mediaFile = FileHelper.combinePath(tempDir, "index.dat");
		String xmlFile = FileHelper.combinePath(tempDir, "index.xml");
		String resDir = context.getAttribute(Constants.CONTEXT_WEB_RESOURCES_TEMP_DIR);
		String publishFile = context.getAttribute(Constants.CONTEXT_HJPACK);

		validateFileExistence(resDir);
		addFileToPackFiles(mediaFile, packFiles);
		addFileToPackFiles(xmlFile, packFiles);

		FileHelper.ensureExists(publishFile, true);
		packFiles.addAll(FileHelper.getAllFileInDir(resDir, true));

		FileHelper.archiveFiles(packFiles, publishFile, AppConfig.getInstance().getIgnoreExtNames(), true);
		FileHelper.deleteDir(resDir);
		FileHelper.deleteDir(tempDir);

		return null;
	}

	private void validateFileExistence(String filePath) throws FileNotFoundException {
		if (!FileHelper.exists(filePath)) {
			throw new FileNotFoundException(filePath);
		}
	}

	private void addFileToPackFiles(String filePath, List<String> packFiles) throws FileNotFoundException {
		validateFileExistence(filePath);
		packFiles.add(filePath);
	}

	@Override
	public String name() {
		return "media.pack.step";
	}
}
