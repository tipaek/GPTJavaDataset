package com.yeshj.pacman.utils;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public final class StringHelper {

	public static String removeFileExtName(String file) {
		if (StringUtils.isEmpty(file)) {
			return "";
		} else if (file.indexOf('.') < 0) {
			return file;
		}
		return file.substring(0, file.indexOf('.'));
	}

	public static String getFileBareName(String url) {
		if (StringUtils.isBlank(url)) {
			return "";
		}
		String[] arr = url.split("\\/|\\\\");
		return arr[arr.length - 1];
	}

	public static int tryParse(String str, int defaultValue) {
		if (StringUtils.isNumeric(str)) {
			return Integer.parseInt(str);
		} else {
			return defaultValue;
		}
	}

	public static boolean isEmpty(String str) {
		return StringUtils.isBlank(str);
	}

	public static String random() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
