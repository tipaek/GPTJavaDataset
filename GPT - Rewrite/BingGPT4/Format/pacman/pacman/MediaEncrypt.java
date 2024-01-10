package com.yeshj.pacman;

import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;
import com.yeshj.pacman.utils.FileHelper;

public final class MediaEncrypt {

	private static final ILog logger = LogFactory.getLog(MediaEncrypt.class);
	private static boolean gJNILoaded = false;

	static {
		try {
			if (FileHelper.isWindow())
				System.loadLibrary("libdec");
			else
				System.loadLibrary("dec");
			gJNILoaded = true;
		} catch (UnsatisfiedLinkError e) {
			logger.error("Can not load dynamic library![libdec]", e);
		}
	}

	private native int encode(String srcFile, String destFile);

	private native int decode(String srcFile, String destFile);

	public boolean encodeMedia(String src, String dest) {
		if (gJNILoaded) {
			return encode(src, dest) == 0;
		}
		return false;
	}

	public boolean decodeMedia(String src, String dest) {
		if (gJNILoaded) {
			return decode(src, dest) == 0;
		}
		return false;
	}
}
